package in.co.rays.project0.Service;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.DAO.SubjectDAOInt;
import in.co.rays.project0.DTO.CourseDTO;
import in.co.rays.project0.DTO.SubjectDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;


/**
 * Session facade of Subject Service. It is transactional, apply delcarative
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

@Service("subjectService")
public class SubjectServiceSpringImpl implements SubjectServiceInt {
	@Autowired
    private SubjectDAOInt dao;
	@Autowired
	private CourseServiceInt model;
    private static Logger log = Logger.getLogger(SubjectServiceSpringImpl.class);

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public long add(SubjectDTO dto) throws DuplicateRecordException {
        log.debug("Subject Service Add Started");
        SubjectDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Subject already exists");
        }
        CourseDTO courseDTO=model.findByPK(dto.getCourseId());
        dto.setCourseName(courseDTO.getName());
        long pk = dao.add(dto);
        log.debug("Subject Service Add Ended");
        return pk;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public long update(SubjectDTO dto) throws DuplicateRecordException {

        log.debug("Subject Service update Started");
        SubjectDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null&&dtoExist.getId() != dto.getId()) {
            throw new DuplicateRecordException("Subject  already exists");
        }
        CourseDTO courseDTO=model.findByPK(dto.getCourseId());
        dto.setCourseName(courseDTO.getName());
       long pk= dao.update(dto);
        log.debug("Subject Service update End");
		return pk;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(SubjectDTO dto) {

        log.debug("Subject Service delete Start");
           dao.delete(dto);
        log.debug("Subject Service delete End");
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SubjectDTO findByName(String SubjectName) {
        log.debug("Subject Service findByName Started");
        SubjectDTO dto = dao.findByName(SubjectName);
        log.debug("Subject Service findByName Ended");
        return dto;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SubjectDTO findByPK(long id) {
        log.debug("Subject Service findById Started");
        
        SubjectDTO dto = dao.findByPK(id);
       
        log.debug("Subject Service findById Ended");

        return dto;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize) {
        return dao.search(dto, pageNo, pageSize);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<SubjectDTO> search(SubjectDTO dto) {
        return dao.search(dto);
    }

	

	

}
