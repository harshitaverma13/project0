package in.co.rays.project0.Service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.DAO.FacultyDAOInt;
import in.co.rays.project0.DTO.CollegeDTO;
import in.co.rays.project0.DTO.CourseDTO;
import in.co.rays.project0.DTO.FacultyDTO;
import in.co.rays.project0.DTO.SubjectDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;


/**
 * Session facade of Faculty Service. It is transactional, apply delcarative
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

@Service("facultyService")
public class FacultyServiceSpringImpl implements FacultyServiceInt {
	@Autowired
	private FacultyDAOInt dao;
	@Autowired
	SubjectServiceInt subjectModel;
	@Autowired
	CourseServiceInt courseModel;
	@Autowired
	CollegeServiceInt collegeModel;

	private static Logger log = Logger.getLogger(FacultyServiceSpringImpl.class);
 
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(FacultyDTO dto) throws DuplicateRecordException {
		log.debug("Faculty Service Add Started");
		FacultyDTO dtoExist = dao.findByEmailId(dto.getEmailId());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Email is already exists");
		}
		SubjectDTO subjectDTO = subjectModel.findByPK(dto.getSubjectId());
		dto.setSubject(subjectDTO.getName());
		
		CourseDTO courseDTO=courseModel.findByPK(dto.getCourseId());
		dto.setCourseName(courseDTO.getName());
		
		CollegeDTO collegeDTO=collegeModel.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());

		long pk = dao.add(dto);
		log.debug("Faculty Service Add Ended");
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long update(FacultyDTO dto) throws DuplicateRecordException {

		log.debug("Faculty Service update Started");
		FacultyDTO dtoExist = dao.findByEmailId(dto.getEmailId());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Eamil is already exists");
		}
		
		SubjectDTO subjectDTO = subjectModel.findByPK(dto.getSubjectId());
		dto.setSubject(subjectDTO.getName());
		
		CourseDTO courseDTO=courseModel.findByPK(dto.getCourseId());
		dto.setCourseName(courseDTO.getName());
		
		CollegeDTO collegeDTO=collegeModel.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());

		long pk = dao.update(dto);
		log.debug("Faculty Service update End");
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(FacultyDTO dto) {

		log.debug("Faculty Service delete Start");

		dao.delete(dto);
		log.debug("Faculty Service delete End");
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public FacultyDTO findByEmailId(String FacultyName) {
		log.debug("Faculty Service findByName Started");
		FacultyDTO dto = dao.findByEmailId(FacultyName);
		log.debug("Faculty Service findByName Ended");
		return dto;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public FacultyDTO findByPK(long id) {
		log.debug("Faculty Service findById Started");

		FacultyDTO dto = dao.findByPK(id);

		log.debug("Faculty Service findById Ended");

		return dto;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<FacultyDTO> search(FacultyDTO dto) {
		return dao.search(dto);
	}

}
