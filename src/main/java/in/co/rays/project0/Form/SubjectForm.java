package in.co.rays.project0.Form;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.DTO.BaseDTO;
import in.co.rays.project0.DTO.SubjectDTO;

/**
 * Contains Subject form elements and their declarative input validations.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public class SubjectForm extends BaseForm {
	/**
	 * Name of Subject
	 */
	@NotEmpty
	private String name;
	/**
	 * description of Subject
	 */
	@NotEmpty
	private String description;
	/**
	 * courseId of Subject
	 */
	@NotNull
	private Long courseId;
	
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
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	
	  @Override
	    public BaseDTO getDto() {
	        SubjectDTO dto = new SubjectDTO();

	        dto.setId(id);
	        dto.setName(name);
	        dto.setCourseId(courseId);
	        dto.setDescription(description);
	       
	       
	        return dto;
	    }

	    @Override
	    public void populate(BaseDTO bDto) {

	        SubjectDTO dto = (SubjectDTO) bDto;

	        id = dto.getId();
	        name = dto.getName();
	        courseId = dto.getCourseId();
	       
	        description = dto.getDescription();
	       

	    }
}
