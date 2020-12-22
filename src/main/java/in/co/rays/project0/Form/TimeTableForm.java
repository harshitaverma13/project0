package in.co.rays.project0.Form;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.DTO.BaseDTO;
import in.co.rays.project0.DTO.TimeTableDTO;
import in.co.rays.project0.Util.Util;


/**
 * Contains Time Table form elements and their declarative input validations.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public class TimeTableForm extends BaseForm {
	/**
	 * courseId of TimeTable
	 */
	@NotNull
	private Long courseId;

	
	/**
	 * subjectId of TimeTable
	 */
	@NotNull
	private Long subjectId;

	
	/**
	 * semester of TimeTable
	 */
	@NotEmpty
	private String semester;

	/**
	 * examDate of TimeTable
	 */
	@NotEmpty
	private String examDate;

	/**
	 * time of TimeTable
	 */
	@NotEmpty
	private String examTime;

	/**
	 * accessor
	 */
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	@Override
	public BaseDTO getDto() {
		TimeTableDTO dto = new TimeTableDTO();

		dto.setId(id);
		dto.setCourseId(courseId);
	
		dto.setExamDate(Util.getDate(examDate));
		dto.setExamTime(examTime);
		dto.setSemester(semester);
		dto.setSubjectId(subjectId);
	

		return dto;
	}

	

	@Override
	public void populate(BaseDTO bDto) {

		TimeTableDTO dto = (TimeTableDTO) bDto;

		id = dto.getId();
		courseId = dto.getCourseId();
		
		examDate = Util.getDate(dto.getExamDate());
		examTime = dto.getExamTime();

		semester = dto.getSemester();
		subjectId = dto.getSubjectId();
		

	}

}
