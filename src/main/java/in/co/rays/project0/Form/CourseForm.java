package in.co.rays.project0.Form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.DTO.BaseDTO;
import in.co.rays.project0.DTO.CourseDTO;

/**
 * Contains Course form elements and their declarative input validations.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public class CourseForm extends BaseForm{
	/**
	 * Name of Course
	 */
	@NotEmpty
	private String name;

	/**
	 * description of Course
	 */
	@NotEmpty
	private String description;
	/**
	 * duration of Course
	 */
	@NotEmpty
	private String duration;
	
	/*
     * Accesor Methods
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	 @Override
	    public BaseDTO getDto() {
	        CourseDTO dto=new CourseDTO();

	        dto.setId(id);
	        dto.setName(name);
	        dto.setDuration(duration);
	        dto.setDescription(description);
	       
	        dto.setCreatedBy(createdBy);
	        dto.setModifiedBy(modifiedBy);
	        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

	        return dto;
	    }

	    @Override
	    public void populate(BaseDTO bDto) {

	        CourseDTO dto = (CourseDTO) bDto;

	        id = dto.getId();
	        name = dto.getName();
	        duration = dto.getDuration();
	        description = dto.getDescription();
	       
	        createdBy = dto.getCreatedBy();
	        modifiedBy = dto.getModifiedBy();
	        if (dto.getCreatedDatetime() != null) {
	            createdDatetime = dto.getCreatedDatetime().getTime();
	        }
	        if (dto.getModifiedDatetime() != null) {
	            modifiedDatetime = dto.getModifiedDatetime().getTime();
	        }

	    }
	
}
