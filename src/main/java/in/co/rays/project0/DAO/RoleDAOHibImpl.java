package in.co.rays.project0.DAO;
import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.project0.DTO.RoleDTO;



/**
 * Hibernate Implementation of RoleDAO
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 * 
 */
@Repository("roleDAO")
public class RoleDAOHibImpl implements RoleDAOInt {
	 @Autowired
	    SessionFactory sessionFactory = null;

	    private static Logger log = Logger.getLogger(RoleDAOHibImpl.class);

	    public long add(RoleDTO dto) {
	        log.debug("Role Dao Add Started");
	        long pk = (Long) sessionFactory.getCurrentSession().save(dto);
	        log.debug("Role Dao Add End");
	        return pk;
	    }

	    public void update(RoleDTO dto) {

	        log.debug("Role Dao Update Started");
	        sessionFactory.getCurrentSession().update(dto);
	        log.debug("Role Dao Update End");

	    }

	    public void delete(RoleDTO dto) {
	        log.debug("Role Dao Delete Started");
	        sessionFactory.getCurrentSession().delete(dto);
	        log.debug("Role Dao Delete End");

	    }

	    public RoleDTO findByName(String roleName) {
	        log.debug("Role DAO Find by Name Started");
	        RoleDTO dto = null;
	        List list = sessionFactory.getCurrentSession()
	                .createCriteria(RoleDTO.class)
	                .add(Restrictions.eq("roleName", roleName)).list();

	       

	        if (list.size() == 1) {
	            dto = (RoleDTO) list.get(0);
	           
	        }
	        log.debug("Role DAO Find by Name Ended");
	        return dto;

	    }

	    public RoleDTO findByPK(long pk) {
	        log.debug("RoleDAO Find by PK Started");
	        System.out.println("in find by pk dao start");
	        RoleDTO dto = null;
	        dto = (RoleDTO) sessionFactory.openSession().get(RoleDTO.class, pk);

	        log.debug("RoleDAO Find by PK Ended");
	       
	        return dto;
	    }

	    public List search(RoleDTO dto, int pageNo, int pageSize)
	            throws DataAccessException {
	        log.debug("DAO search Started");

	        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
	                RoleDTO.class);

	        if (dto != null) {
	            if (dto.getId() > 0) {
	                criteria.add(Restrictions.eq("id", dto.getId()));
	            }
	            if (dto.getRoleName() != null && dto.getRoleName().length() > 0) {
	                criteria.add(Restrictions.like("roleName", dto.getRoleName()
	                        + "%"));
	            }
	            if (dto.getRoleDescription() != null
	                    && dto.getRoleDescription().length() > 0) {
	                criteria.add(Restrictions.like("roleDescription",
	                        dto.getRoleDescription() + "%"));
	            }
	        }

	        // if page size is greater than zero the apply pagination
	        if (pageSize > 0) {
	            criteria.setFirstResult((pageNo - 1) * pageSize);
	            criteria.setMaxResults(pageSize);
	        }

	        List list = criteria.list();

	        log.debug("DAO search End");

	        return list;

	    }

	    public List search(RoleDTO dto) throws DataAccessException {
	        return search(dto, 0, 0);
	    }


}
