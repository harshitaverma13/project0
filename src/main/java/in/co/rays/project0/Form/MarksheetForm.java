package in.co.rays.project0.Form;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.DTO.BaseDTO;
import in.co.rays.project0.DTO.MarksheetDTO;


/**
 * Contains MArksheet form elements and their declarative input validations.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public class MarksheetForm extends BaseForm{
	 protected long id = 0;

	    @NotEmpty
	    private String rollNo = null;
	    
	    /**
		 * Name of Student
		 */
	    
	    private String name = null;
	   
	    @NotNull
	    @Min(0)
	    @Max(100)
	    private Integer physics;

	    @NotNull
	    @Min(0)
	    @Max(100)
	    private Integer chemistry;

	    @NotNull
	    @Min(0)
	    @Max(100)
	    protected Integer maths;

	    @NotNull
	    protected Long studentId;

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getRollNo() {
	        return rollNo;
	    }

	    public void setRollNo(String rollNo) {
	        this.rollNo = rollNo;
	    }

	  

	    public Integer getPhysics() {
	        return physics;
	    }

	    public void setPhysics(Integer physics) {
	        this.physics = physics;
	    }

	    public Integer getChemistry() {
	        return chemistry;
	    }

	    public void setChemistry(Integer chemistry) {
	        this.chemistry = chemistry;
	    }

	    public Integer getMaths() {
	        return maths;
	    }

	    public void setMaths(Integer maths) {
	        this.maths = maths;
	    }

	    public Long getStudentId() {
	        return studentId;
	    }

	    public void setStudentId(Long studentId) {
	        this.studentId = studentId;
	    }

	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
	    public BaseDTO getDto() {

	        MarksheetDTO dto = new MarksheetDTO();
	        dto.setId(id);
	        dto.setMaths(maths);
	        dto.setPhysics(physics);
	        dto.setChemistry(chemistry);
	        dto.setName(name);
	        dto.setRollNo(rollNo);
	        dto.setStudentId(studentId);

	        return dto;
	    }

	    @Override
	    public void populate(BaseDTO bdDto) {

	        MarksheetDTO dto = (MarksheetDTO) bdDto;
	        id = dto.getId();
	       name=dto.getName();
	        maths = dto.getMaths();
	        physics = dto.getPhysics();
	        chemistry = dto.getChemistry();
	        rollNo = dto.getRollNo();
	        studentId = dto.getStudentId();

	    }


}
