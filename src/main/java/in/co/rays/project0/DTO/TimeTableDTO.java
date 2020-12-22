package in.co.rays.project0.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TimeTable JavaBean encapsulates TimeTable attributes
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Entity
@Table(name="ST_TIME_TABLE")
public class TimeTableDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * courseId of TimeTable
	 */
	@Column(name = "COURSEID")
	private Long courseId;

	/**
	 * courseName of TimeTable
	 */
	@Column(name = "COURSENAME", length = 50)
	private String courseName;

	/**
	 * subjectId of TimeTable
	 */
	@Column(name = "SUBJECTID")
	private Long subjectId;

	/**
	 * subjectName of TimeTable
	 */
	@Column(name = "SUBJECTNAME", length = 50)
	private String subjectName;

	/**
	 * semester of TimeTable
	 */
	@Column(name = "SEMESTER")
	private String semester;

	/**
	 * examDate of TimeTable
	 */
	@Column(name = "EXAMDATE")
	private Date examDate;

	/**
	 * time of TimeTable
	 */
	@Column(name = "EXAMTIME")
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return examDate + "";
	}

	

}
