package in.co.rays.project0.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.DTO.TimeTableDTO;



/**
 * Hibernate Implementation of TimeTable DAO
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
@Repository(value = "timetableDAO")
public class TimeTableDAOHibImpl implements TimeTableDAOInt{
	 @Autowired
	    private SessionFactory sessionFactory = null;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	    /**
	     * Add a Timetable
	     */
	    public long add(TimeTableDTO dto) {
	        Session session = sessionFactory.getCurrentSession();
	        session.save(dto);
	        return dto.getId();
	    }

	    /**
	     * Updates a Timetable
	     */
	    public long update(TimeTableDTO dto) {
	        Session session = sessionFactory.getCurrentSession();
	        session.merge(dto);
	        return dto.getId();
	    }

	    /**
	     * Deletes a Timetable
	     */
	    public void delete(TimeTableDTO dto) {
	    
	        Session session = sessionFactory.getCurrentSession();
	        session.delete(dto);

	    }
	    public TimeTableDTO findByCourseAndSubAndSem(Long courseId, Long subjectId, String sem) {
	    	 TimeTableDTO dto = null;
		        Session session = sessionFactory.getCurrentSession();
		        Criteria criteria = session.createCriteria(TimeTableDTO.class);
		        criteria.add(Restrictions.eq("courseId", courseId));
				criteria.add(Restrictions.eq("subjectId", subjectId));
				criteria.add(Restrictions.eq("semester", sem));
				List list = criteria.list();
				if (list.size() == 1) {
		            dto = (TimeTableDTO) list.get(0);
		        }
		      
		        return dto;
			
		}

		public TimeTableDTO findByDateAndCourseIdAndSem(Date examDate, Long courseId, String sem) {
			TimeTableDTO dto = null;
	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(TimeTableDTO.class);
	        criteria.add(Restrictions.eq("examDate", examDate));
			criteria.add(Restrictions.eq("courseId", courseId));
			criteria.add(Restrictions.eq("semester", sem));
			List list = criteria.list();
			if (list.size() == 1) {
	            dto = (TimeTableDTO) list.get(0);
	        }
	      
	        return dto;
		
		}

	

	    public TimeTableDTO findByPK(long id) {

	        
	        Session session = sessionFactory.getCurrentSession();
	        

	        
	        TimeTableDTO dto = (TimeTableDTO) session.get(TimeTableDTO.class, id);
	     
	        return dto;
	    }

	    public List search(TimeTableDTO dto, int pageNo, int pageSize) {
	        
	        List list = null;

	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(TimeTableDTO.class);
	        if (dto != null) {

	        	  if (dto.getId() > 0) {
		                criteria.add(Restrictions.eq("id", dto.getId()));
		            }
		            
		            if (dto.getCourseId() != null) {
		                criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
		            }
		            if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
		                criteria.add(Restrictions.like("courseName", dto.getCourseName()
		                        + "%"));
		            }
		            
		            if (dto.getSubjectId()!=null) {
		                criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
		            }
		            
		            if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
		                criteria.add(Restrictions.like("subjectName", dto.getSubjectName()
		                        + "%"));
		            }
		            if (dto.getExamDate() != null ) {
		                criteria.add(Restrictions.eq("examDate", dto.getExamDate()
		     ));
		            }
		            
		            if (dto.getExamTime() != null && dto.getExamTime().length() > 0) {
		                criteria.add(Restrictions.like("examTime", dto.getExamTime()
		                        + "%"));
		            }
		            if (dto.getSemester() != null && dto.getSemester().length() > 0) {
		                criteria.add(Restrictions.like("semester", dto.getSemester()
		                        + "%"));
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

	    public List search(TimeTableDTO dto) {
	        
	        return search(dto, 0, 0);

	    }

		


}
