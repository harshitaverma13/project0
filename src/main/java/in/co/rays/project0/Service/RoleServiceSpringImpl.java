package in.co.rays.project0.Service;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.DAO.RoleDAOInt;
import in.co.rays.project0.DTO.RoleDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;

/**
 * Session facade of Role Service. It is transactional, apply delcarative
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

@Service("roleService")
public class RoleServiceSpringImpl implements RoleServiceInt  {
	 @Autowired
	    private RoleDAOInt dao;

	    private static Logger log = Logger.getLogger(RoleServiceSpringImpl.class);

	    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	    public long add(RoleDTO dto) throws DuplicateRecordException {
	        log.debug("Role Service Add Started");
	        RoleDTO dtoExist = dao.findByName(dto.getRoleName());
	        if (dtoExist != null) {
	            throw new DuplicateRecordException("Role Name already exists");
	        }
	        long pk = dao.add(dto);
	        log.debug("Role Service Add Ended");
	        return pk;
	    }

	    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	    public void update(RoleDTO dto) throws DuplicateRecordException {

	        log.debug("Role Service update Started");
	        RoleDTO dtoExist = dao.findByName(dto.getRoleName());
	        if (dtoExist != null&&dtoExist.getId() != dto.getId()) {
	            throw new DuplicateRecordException("Role Name already exists");
	        }
	        dao.update(dto);
	        log.debug("Role Service update End");
	    }

	    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	    public void delete(long id) {

	        log.debug("Role Service delete Start");
	        System.out.println("Delete service Started");
	        RoleDTO dto = new RoleDTO();
	        RoleDTO dtoExist = findById(id);

	        System.out.println(dtoExist);

	        dao.delete(dtoExist);
	        log.debug("Role Service delete End");
	    }

	    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	    public RoleDTO findByName(String roleName) {
	        log.debug("Role Service findByName Started");
	        RoleDTO dto = dao.findByName(roleName);
	        log.debug("Role Service findByName Ended");
	        return dto;
	    }

	    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	    public RoleDTO findById(long id) {
	        log.debug("Role Service findById Started");
	        
	        RoleDTO dto = dao.findByPK(id);
	       
	        log.debug("Role Service findById Ended");

	        return dto;
	    }

	    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	    public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize) {
	        return dao.search(dto, pageNo, pageSize);
	    }

	    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	    public List<RoleDTO> search(RoleDTO dto) {
	        return dao.search(dto);
	    }

}
