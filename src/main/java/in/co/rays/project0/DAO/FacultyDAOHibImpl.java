package in.co.rays.project0.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.DTO.FacultyDTO;


/**
 * Hibernate Implementation of FacultyDAO
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
@Repository(value = "facultyDAO")
public class FacultyDAOHibImpl implements FacultyDAOInt {
	@Autowired
	private SessionFactory sessionFactory = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Adds a Faculty
	 */
	public long add(FacultyDTO dto) {

		long pk = 0;
		pk = (Long) sessionFactory.getCurrentSession().save(dto);

		return pk;
	}

	/**
	 * Updates a faculty
	 */
	public long update(FacultyDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().merge(dto);
		return dto.getId();
	}

	public void delete(FacultyDTO dto) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);

	}

	public FacultyDTO findByEmailId(String email) {

		FacultyDTO dto = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FacultyDTO.class);
		List list = (List) criteria.add(Restrictions.eq("emailId", email)).list();

		if (list.size() == 1) {
			dto = (FacultyDTO) list.get(0);
		}

		return dto;

	}

	public FacultyDTO findByPK(long id) {

		Session session = sessionFactory.getCurrentSession();

		FacultyDTO dto = (FacultyDTO) session.get(FacultyDTO.class, id);

		return dto;
	}

	public List search(FacultyDTO dto, int pageNo, int pageSize) {

		List list = null;

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FacultyDTO.class);
		if (dto != null) {

			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getDob() != null && dto.getDob().getDate() > 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
			}
			if (dto.getEmailId() != null && dto.getEmailId().length() > 0) {
				criteria.add(Restrictions.like("emailId", dto.getEmailId() + "%"));
			}
			if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
				criteria.add(Restrictions.like("mobileNo", dto.getMobileNo() + "%"));
			}
		}
		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {

			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}

		list = criteria.list();

		return list;

	}

	public List search(FacultyDTO dto) {

		return search(dto, 0, 0);

	}

}
