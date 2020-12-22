package in.co.rays.project0.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.DAO.UserDAOInt;
import in.co.rays.project0.DTO.RoleDTO;
import in.co.rays.project0.DTO.UserDTO;
import in.co.rays.project0.Exception.ApplicationException;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Exception.RecordNotFoundException;
import in.co.rays.project0.Util.EmailBuilder;

/**
 * Session facade of User Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Service("userService")

public class UserServiceSpringImpl implements UserServiceInt {

	private SessionFactory sessionFactory = null;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private UserDAOInt dao = null;

	@Autowired
	private JavaMailSenderImpl mailSender;

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public void setDao(UserDAOInt dao) {
		this.dao = dao;
	}

	private static Logger log = Logger.getLogger(UserServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(UserDTO dto) throws DuplicateRecordException {
		long pk = 0;
		UserDTO dtoexist = findByLogin(dto.getLogin());
		if (dtoexist != null) {
			throw new DuplicateRecordException("LoginId is already exist");

		} else {
			pk = dao.add(dto);
		}
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long registerUser(UserDTO dto) throws DuplicateRecordException {

		long id = add(dto);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLogin());
		map.put("password", dto.getPassword());

		String message = EmailBuilder.getUserRegistrationMessage(map);
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(dto.getLogin());
			helper.setSubject("Registration is successful for ORS Project SUNRAYS Technologies.");
			// use the true flag to indicate the text included is HTML
			helper.setText(message, true);
			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return id;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(UserDTO dto) throws DuplicateRecordException {
		log.debug("Service update Started");
		UserDTO dtoexist = findByLogin(dto.getLogin());
		if (dtoexist != null && dto.getId() != dto.getId()) {
			throw new DuplicateRecordException("LoginId is already exist");
		} else {
			dao.update(dto);
		}
		log.debug("Service update End");
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("Service Delete Started");
		dao.delete(id);
		log.debug("Service delete End");

	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		log.debug("Service findByLogin Started");
		UserDTO dto = dao.findByLogin(login);
		return dto;
	}

	@Transactional(readOnly = true)
	public UserDTO findByPK(long pk) {

		log.debug("Service findByPK Started");
		UserDTO dto = dao.findByPK(pk);
		log.debug("Service findByPK End");
		return dto;
	}

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto) {
		return dao.search(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean changePassword(Long id, String oldPassword, String newPassword)
			throws DuplicateRecordException, RecordNotFoundException {

		boolean flag = false;
		UserDTO dtoExist = null;
		dtoExist = findByPK(id);
		if (dtoExist != null && dtoExist.getPassword().equals(oldPassword)) 
		{
			if (!dtoExist.getPassword().equals(newPassword)) 
			{
				dtoExist.setPassword(newPassword);
				update(dtoExist);
				flag = true;

			} else {
				throw new DuplicateRecordException("new password and old password both are same");
			      }
		} else {
			throw new RecordNotFoundException("Old Password is Invalid");
		}

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dtoExist.getLogin());
		map.put("password", dtoExist.getPassword());
		map.put("firstName", dtoExist.getFirstName());
		map.put("lastName", dtoExist.getLastName());
		String message = EmailBuilder.getChangePasswordMessage(map);

		MimeMessage msg = mailSender.createMimeMessage();

		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(msg, true);
			helper.setTo(dtoExist.getLogin());
			helper.setSubject("Password has been changed.");
			// use the true flag to indicate the text included is HTML
			helper.setText(message, true);
		} catch (MessagingException e) {
			System.out.println("Mail Sending Failed");
			e.printStackTrace();
		}
		mailSender.send(msg);
		return flag;
	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(String login, String password) throws RecordNotFoundException {
		log.debug("DAO findByLoginId Started");
		UserDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		} else {
			dto = null;
			throw new RecordNotFoundException("Invalid Login Id And Password");

		}
		return dto;

	}

	/*
	 * @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	 * public boolean lock(String login) { log.debug("Service lock Started");
	 * boolean flag = false; UserDTO dtoExist = null; dtoExist =
	 * findByLogin(login); if (dtoExist != null) {
	 * dtoExist.setLock(UserDTO.ACTIVE); dao.update(dtoExist); flag = true; }
	 * else { } log.debug("Service lock End"); return flag; }
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public boolean resetPassword(String login) throws ApplicationException {
		log.debug("Service resetPassword Started");
		boolean flag = false;
		UserDTO dtoExist = null;
		dtoExist = dao.findByLogin(login);
		if (dtoExist != null) {
			String newPassword = String.valueOf(new Date().getTime()).substring(0, 4);
			dtoExist.setPassword(newPassword);
			dao.update(dtoExist);

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("login", dtoExist.getLogin());
			map.put("password", dtoExist.getPassword());
			map.put("firstName", dtoExist.getFirstName());
			map.put("lastName", dtoExist.getLastName());
			String message = EmailBuilder.getForgetPasswordMessage(map);

			MimeMessage msg = mailSender.createMimeMessage();

			// use the true flag to indicate you need a multipart message
			MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(msg, true);
				helper.setTo(dtoExist.getLogin());
				helper.setSubject("Password has been reset.");
				// use the true flag to indicate the text included is HTML
				helper.setText(message, true);
			} catch (MessagingException e) {

				e.printStackTrace();
			}
			mailSender.send(msg);

			flag = true;
		} else {
		}
		log.debug("Service restPassword End");
		return flag;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean forgetPassword(String login) throws ApplicationException {
		log.debug("Service forgetPassword Started");
		UserDTO dtoExist = dao.findByLogin(login);
		if (dtoExist != null) {

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("firstName", dtoExist.getFirstName());
			map.put("lastName", dtoExist.getLastName());
			map.put("login", dtoExist.getLogin());
			map.put("password", dtoExist.getPassword());

			String message = EmailBuilder.getForgetPasswordMessage(map);

			MimeMessage msg = mailSender.createMimeMessage();

			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg);
				helper.setTo(login);
				helper.setSubject("SunilOS ORS Password reset");
				// use the true flag to indicate the text included is HTML
				helper.setText(message, true);
				mailSender.send(msg);
			} catch (MessagingException e) {
				e.printStackTrace();
				log.error(e);
				return false;
			}
		} else {
			return false;
		}
		log.debug("Service forgetPassword End");
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public RoleDTO getRole(UserDTO dto) {
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public UserDTO updateAccess(UserDTO dto) {
		return null;
	}

	public boolean lock(String login) {
		// TODO Auto-generated method stub
		return false;
	}

}
