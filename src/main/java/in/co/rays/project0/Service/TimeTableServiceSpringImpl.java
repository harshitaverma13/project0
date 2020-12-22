package in.co.rays.project0.Service;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.DAO.TimeTableDAOInt;
import in.co.rays.project0.DTO.CourseDTO;
import in.co.rays.project0.DTO.SubjectDTO;
import in.co.rays.project0.DTO.TimeTableDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;

/**
 * Session facade of Timetable Service. It is transactional, apply delcarative
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

@Service("timetableService")
public class TimeTableServiceSpringImpl implements TimeTableServiceInt {
	@Autowired
    private TimeTableDAOInt dao;
	@Autowired
	SubjectServiceInt subjectModel;
	@Autowired
	CourseServiceInt courseModel;
	

    private static Logger log = Logger.getLogger(TimeTableServiceSpringImpl.class);

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public long add(TimeTableDTO dto) throws DuplicateRecordException {
        log.debug("TimeTable Service Add Started");
        TimeTableDTO dtoExist1 = dao.findByCourseAndSubAndSem(dto.getCourseId(), dto.getSubjectId(), dto.getSemester());
        TimeTableDTO dtoExist2 = dao.findByDateAndCourseIdAndSem(dto.getExamDate(), dto.getSubjectId(), dto.getSemester());
        
        if (dtoExist1 != null) {
            throw new DuplicateRecordException("Timetable is already exists");
        }
        if (dtoExist2 != null) {
            throw new DuplicateRecordException("Exam date already schedule for this course!");
        }
        
        SubjectDTO subjectDto=subjectModel.findByPK(dto.getSubjectId());
        dto.setSubjectName(subjectDto.getName());
        
        CourseDTO courseDTO=courseModel.findByPK(dto.getCourseId());
        dto.setCourseName(courseDTO.getName());
        
        long pk = dao.add(dto);
        log.debug("TimeTable Service Add Ended");
        return pk;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public long update(TimeTableDTO dto) throws DuplicateRecordException {

        log.debug("TimeTable Service update Started");
        TimeTableDTO dtoExist1 = dao.findByCourseAndSubAndSem(dto.getCourseId(), dto.getSubjectId(), dto.getSemester());
        TimeTableDTO dtoExist2 = dao.findByDateAndCourseIdAndSem(dto.getExamDate(), dto.getSubjectId(), dto.getSemester());
        
        if (dtoExist1 != null&&dtoExist1.getId() != dto.getId()) {
            throw new DuplicateRecordException("TimeTable Name already exists");
        }
        if (dtoExist2 != null&&dtoExist2.getId() != dto.getId()) {
            throw new DuplicateRecordException("Exam date already schedule for this course!");
        }
        SubjectDTO subjectDto=subjectModel.findByPK(dto.getSubjectId());
        dto.setSubjectName(subjectDto.getName());
        
        CourseDTO courseDTO=courseModel.findByPK(dto.getCourseId());
        dto.setCourseName(courseDTO.getName());
        
       
       long pk= dao.update(dto);
     
        log.debug("TimeTable Service update End");
        return pk;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(TimeTableDTO dto) {

        log.debug("TimeTable Service delete Start");
        dao.delete(dto);
        log.debug("TimeTable Service delete End");
    }

  
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public TimeTableDTO findByPK(long id) {
        log.debug("TimeTable Service findById Started");
        
        TimeTableDTO dto = dao.findByPK(id);
       
        log.debug("TimeTable Service findById Ended");

        return dto;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize) {
        return dao.search(dto, pageNo, pageSize);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<TimeTableDTO> search(TimeTableDTO dto) {
        return dao.search(dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public TimeTableDTO findByCourseAndSubAndSem(Long courseId, Long subjectId, String sem) {
    	 log.debug("TimeTable Service findByCourseAndSubAndSem Started");
         TimeTableDTO dto = dao.findByCourseAndSubAndSem(courseId, subjectId, sem);
         log.debug("TimeTable Service findByCourseAndSubAndSem Ended");
         return dto;
	}
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public TimeTableDTO findByDateAndCourseIdAndSem(Date examDate, Long courseId, String sem) {
    	 log.debug("TimeTable Service findByDateAndCourseIdAndSem Started");
         TimeTableDTO dto = dao.findByDateAndCourseIdAndSem(examDate, courseId, sem);
         log.debug("TimeTable Service findByDateAndCourseIdAndSem Ended");
         return dto;
	}
}
