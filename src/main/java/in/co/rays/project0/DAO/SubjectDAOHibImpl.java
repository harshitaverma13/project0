package in.co.rays.project0.DAO;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.DTO.SubjectDTO;



/**
 * Hibernate Implementation of Subject DAO
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
@Repository(value = "subjectDAO")
public class SubjectDAOHibImpl implements SubjectDAOInt {
	 @Autowired
	    private SessionFactory sessionFactory = null;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	    /**
	     * Adds a Subject
	     */
	    public long add(SubjectDTO dto) {
	        Session session = sessionFactory.getCurrentSession();
	        session.save(dto);
	        return dto.getId();
	    }

	    /**
	     * Updates a Subject
	     */
	    public long update(SubjectDTO dto) {
	        Session session = sessionFactory.getCurrentSession();
	        session.update(dto);
	        return dto.getId();
	    }

	    /**
	     * Deletes a Subject
	     */
	    public void delete(SubjectDTO dto) {
	     
	        Session session = sessionFactory.getCurrentSession();
	        session.delete(dto);

	    }

	    public SubjectDTO findByName(String name) {
	      
	        SubjectDTO dto = null;
	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(SubjectDTO.class);
	        List list = (List) criteria.add(Restrictions.eq("name", name)).list();

	        if (list.size() == 1) {
	            dto = (SubjectDTO) list.get(0);
	        }
	      
	        return dto;

	    }

	    public SubjectDTO findByPK(long id) {
	        Session session = sessionFactory.getCurrentSession();
	        SubjectDTO dto = (SubjectDTO) session.get(SubjectDTO.class, id);
	        return dto;
	    }

	    public List search(SubjectDTO dto, int pageNo, int pageSize) {
	        
	        List list = null;

	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(SubjectDTO.class);
	        if (dto != null) {

	        	 if (dto.getId() > 0) {
		                criteria.add(Restrictions.eq("id", dto.getId()));
		            }
		            
		            if (dto.getName() != null && dto.getName().length() > 0) {
		                criteria.add(Restrictions.like("name", dto.getName() + "%"));
		            }
		            
		           
		            if (dto.getCourseId() !=null) {
		                criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
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

	    public List search(SubjectDTO dto) {
	       
	        return search(dto, 0, 0);

	    }

		

		
	


}
