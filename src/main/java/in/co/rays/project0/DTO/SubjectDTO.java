package in.co.rays.project0.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Subject JavaBean encapsulates Subject attributes
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Entity
@Table(name="ST_SUBJECT")
public class SubjectDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Name of Subject
	 */
	@Column(name = "NAME", length = 50)
	private String name;
	/**
	 * description of Subject
	 */
	@Column(name = "DESCRIPTION")
	private String description;
	/**
	 * courseId of Subject
	 */
	@Column(name = "COURSEID") 
	private Long courseId;
	/**
	 * courseName of Subject
	 */
	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;

	 /**
     * accessor
     */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public String getKey() {
		return id + "";

	}

	public String getValue() {
		return name + "";
	}

}
