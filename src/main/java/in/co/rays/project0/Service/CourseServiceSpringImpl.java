package in.co.rays.project0.Service;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.DAO.CourseDAOInt;
import in.co.rays.project0.DTO.CourseDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;


/**
 * Session facade of Course Service. It is transactional, apply delcarative
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

@Service("courseService")
public class CourseServiceSpringImpl implements CourseServiceInt{
	@Autowired
    private CourseDAOInt dao;

    private static Logger log = Logger.getLogger(CourseServiceSpringImpl.class);

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public long add(CourseDTO dto) throws DuplicateRecordException {
        log.debug("Course Service Add Started");
        CourseDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Course Name already exists");
        }
        long pk = dao.add(dto);
        log.debug("Course Service Add Ended");
        return pk;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public long update(CourseDTO dto) throws DuplicateRecordException {

        log.debug("Course Service update Started");
        CourseDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null&&dtoExist.getId() != dto.getId()) {
            throw new DuplicateRecordException("Course Name already exists");
        }
       long pk= dao.update(dto);
        log.debug("Course Service update End");
		return pk;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(CourseDTO dto) {

        log.debug("Course Service delete Start");
        
        dao.delete(dto);
        log.debug("Course Service delete End");
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public CourseDTO findByName(String CourseName) {
        log.debug("Course Service findByName Started");
        CourseDTO dto = dao.findByName(CourseName);
        log.debug("Course Service findByName Ended");
        return dto;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public CourseDTO findByPK(long id) {
        log.debug("Course Service findById Started");
        
        CourseDTO dto = dao.findByPK(id);
       
        log.debug("Course Service findById Ended");

        return dto;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize) {
        return dao.search(dto, pageNo, pageSize);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<CourseDTO> search(CourseDTO dto) {
        return dao.search(dto);
    }

	
	

}
