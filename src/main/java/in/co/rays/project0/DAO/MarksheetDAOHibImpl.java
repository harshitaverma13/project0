package in.co.rays.project0.DAO;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.DTO.MarksheetDTO;



/**
 * Hibernate Implementation of Marksheet DAO
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
@Repository("marksheetDAO")
public class MarksheetDAOHibImpl implements MarksheetDAOInt {
	@Autowired
    private SessionFactory sessionFactory = null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // add method
    public long add(MarksheetDTO dto) {
        return (Long) sessionFactory.getCurrentSession().save(dto);
    }

    // update method
    public long update(MarksheetDTO dto) {
        sessionFactory.getCurrentSession().update(dto);
        return dto.getId();
    }

    // delete method
    public void delete(long id) {
        MarksheetDTO dto = new MarksheetDTO();
        dto.setId(id);
        sessionFactory.getCurrentSession().delete(dto);
    }

    // List Search
    public List search(MarksheetDTO dto) {
        return search(dto, 0, 0);
    }

    // List Search pagination
    public List search(MarksheetDTO dto, int pageNo, int pageSize) {
        System.out.println("DAO search Started");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                MarksheetDTO.class);
        if (dto != null){
        if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }
        if (dto.getRollNo() != null && dto.getRollNo().length() > 0) {
            criteria.add(Restrictions.eq("rollNo", dto.getRollNo()));
        }
        if(dto.getStudentId()!=null){
        	criteria.add(Restrictions.eq("studentId", dto.getStudentId()));
       }
        if (dto.getName() != null && dto.getName().length() > 0) {
            criteria.add(Restrictions.like("name", dto.getName() + "%"));
        }
        if (dto.getPhysics() != null && dto.getPhysics() > 0) {
            criteria.add(Restrictions.eq("physics", dto.getPhysics()));
        }
        if (dto.getChemistry() != null && dto.getChemistry() > 0) {
            criteria.add(Restrictions.eq("chemistry", dto.getChemistry()));
        }
        if (dto.getMaths() != null && dto.getMaths() > 0) {
            criteria.add(Restrictions.eq("maths", dto.getMaths()));
        }
        }

        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult(((pageNo - 1) * pageSize));
            criteria.setMaxResults(pageSize);
        }

        
        return criteria.list();
    }

    public MarksheetDTO findByPK(long pk) {
        Session session = sessionFactory.getCurrentSession();
        MarksheetDTO dto = (MarksheetDTO) session.get(MarksheetDTO.class, pk);
        session.evict(dto);
        return dto;
    }

    public MarksheetDTO findByRollNo(String rollNo) {

        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(MarksheetDTO.class);
        criteria.add(Restrictions.eq("rollNo", rollNo));
        List<MarksheetDTO> list = criteria.list();

        MarksheetDTO dto = null;

        if (list.size() == 1) {
            dto = (MarksheetDTO) list.get(0);
            session.evict(dto);
        }
        return dto;
    }

    public List getMeritList(int pageNo, int pageSize) {

    	 Session session = sessionFactory.getCurrentSession();

         Criteria criteria = session.createCriteria(MarksheetDTO.class);
         
         criteria.addOrder(Order.desc("total"));
         criteria.add(Restrictions.between("physics", 33, 100));
         criteria.add(Restrictions.between("chemistry", 33, 100));
         criteria.add(Restrictions.between("maths", 33, 100));
         // if page size is greater than zero then apply pagination
         if (pageSize > 0) {
             pageNo = ((pageNo - 1) * pageSize) ;
             criteria.setFirstResult(pageNo);
             criteria.setMaxResults(pageSize);
         }

        

        return criteria.list();
    }
}
