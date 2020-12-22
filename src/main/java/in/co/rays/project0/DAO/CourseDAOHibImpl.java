package in.co.rays.project0.DAO;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.DTO.CourseDTO;
/**
 * Hibernate Implementation of CourseDAO
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
@Repository(value = "courseDAO")
public class CourseDAOHibImpl implements CourseDAOInt {
	 @Autowired
	    private SessionFactory sessionFactory = null;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	    /**
	     * Adds a Course
	     */
	    public long add(CourseDTO dto) {
	        Session session = sessionFactory.getCurrentSession();
	        session.save(dto);
	        return dto.getId();
	    }

	    /**
	     * Updates a Course
	     */
	    public long update(CourseDTO dto) {
	        Session session = sessionFactory.getCurrentSession();
	        session.update(dto);
	        return dto.getId();
	    }

	    /**
	     * Deletes a Course
	     */
	    public void delete(CourseDTO dto) {
	       
	        Session session = sessionFactory.getCurrentSession();
	        session.delete(dto);

	    }

	    public CourseDTO findByName(String name) {
	       
	        CourseDTO dto = null;
	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(CourseDTO.class);
	        List list = (List) criteria.add(Restrictions.eq("name",name)).list();

	        if (list.size() == 1) {
	            dto = (CourseDTO) list.get(0);
	        }
	      
	        return dto;

	    }

	    public CourseDTO findByPK(long id) {

	        
	        Session session = sessionFactory.getCurrentSession();
	        

	        
	        CourseDTO dto = (CourseDTO) session.get(CourseDTO.class, id);
	     
	        return dto;
	    }

	    public List search(CourseDTO dto, int pageNo, int pageSize) {
	        
	        List list = null;

	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(CourseDTO.class);
	        if (dto != null) {

	        	if (dto.getId() > 0) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getName() != null && dto.getName().length() > 0) {
					criteria.add(Restrictions.like("name", dto.getName() + "%"));

				}
				if (dto.getDuration() != null && dto.getDuration().length() > 0) {
					criteria.add(Restrictions.like("duration", dto.getDuration() + "%"));
				}
				if (dto.getDescription() != null && dto.getDescription().length() > 0) {
					criteria.add(Restrictions.like("description", dto.getDescription() + "%"));
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

	    public List search(CourseDTO dto) {
	       
	        return search(dto, 0, 0);

	    }

		


	
}
