package in.co.rays.project0.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Course JavaBean encapsulates Course attributes
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
@Entity
@Table(name="ST_COURSE")
public class CourseDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * Name of Course
	 */
	@Column(name = "NAME", length = 50)
	private String name;

	/**
	 * description of Course
	 */
	@Column(name = "DESCRIPTION")
	private String description;
	/**
	 * duration of Course
	 */
	@Column(name = "DURATION")
	private String duration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descreption) {
		this.description = descreption;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return name;
	}
}
