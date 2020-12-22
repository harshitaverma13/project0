package in.co.rays.project0.DAO;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.DTO.StudentDTO;




/**
 * Hibernate Implementation of StudentDAO
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
@Repository(value = "studentDAO")
public class StudentDAOHibImpl implements StudentDAOInt {
	 @Autowired
	    private SessionFactory sessionFactory = null;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	    /**
	     * Adds a Student
	     */
	    public long add(StudentDTO dto) {
	        Session session = sessionFactory.getCurrentSession();
	        session.save(dto);
	        return dto.getId();
	    }

	    /**
	     * Updates a Student
	     */
	    public long update(StudentDTO dto) {
	        Session session = sessionFactory.getCurrentSession();
	        session.update(dto);
	        return dto.getId();
	    }

	    /**
	     * Deletes a Student
	     */
	    public void delete(long id) {
	        StudentDTO dto = findByPK(id);
	        Session session = sessionFactory.getCurrentSession();
	        session.delete(dto);

	    }

	    public StudentDTO findByEmail(String email) {
	        System.out.println("in findBy email");
	        StudentDTO dto = null;
	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(StudentDTO.class);
	        List list = (List) criteria.add(Restrictions.eq("email", email)).list();

	        if (list.size() == 1) {
	            dto = (StudentDTO) list.get(0);
	        }
	      
	        return dto;

	    }

	    public StudentDTO findByPK(long id) {

	        
	        Session session = sessionFactory.getCurrentSession();
	        

	        
	        StudentDTO dto = (StudentDTO) session.get(StudentDTO.class, id);
	     
	        return dto;
	    }

	    public List search(StudentDTO dto, int pageNo, int pageSize) {
	        
	        List list = null;

	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(StudentDTO.class);
	        if (dto != null) {

	            if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
	                criteria.add(Restrictions.like("firstName", dto.getFirstName()
	                        + "%"));
	            }
	            if (dto.getLastName() != null && dto.getLastName().length() > 0) {
	                criteria.add(Restrictions.like("lastName", dto.getLastName()
	                        + "%"));
	            }
	            if (dto.getDob() != null) {
	                criteria.add(Restrictions.eq("dob", dto.getDob()));
	            }
	            if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
	                criteria.add(Restrictions.eq("mobileNo", dto.getMobileNo()
	                        + "%"));
	            }
	            if (dto.getEmail() != null && dto.getEmail().length() > 0) {
	                criteria.add(Restrictions.like("email", dto.getEmail() + "%"));
	            }
	        }
	        // if page size is greater than zero the apply pagination
	        if (pageSize > 0) {

	            criteria.setFirstResult((pageNo - 1) * pageSize);
	            criteria.setMaxResults(pageSize);
	        }
	        System.out.println("after DAO Search pagination");

	        list = criteria.list();
	        
	        return list;

	    }

	    public List search(StudentDTO dto) {
	        System.out.println("DAO Search");
	        return search(dto, 0, 0);

	    }


}
