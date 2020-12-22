package in.co.rays.project0.Form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.DTO.BaseDTO;
import in.co.rays.project0.DTO.FacultyDTO;
import in.co.rays.project0.Util.Util;


/**
 * Contains Faculty form elements and their declarative input validations.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public class FacultyForm extends BaseForm {

	/**
	 * collegeId of Faculty
	 */
	@NotNull
	private Long collegeId;
	/**
	 * courseId of Faculty
	 */
	@NotNull
	private Long courseId;
	
	/**
	 * firstName of Faculty
	 */
	@NotEmpty
	private String firstName;
	/**
	 * lastName of Faculty
	 */
	@NotEmpty
	private String lastName;
	/**
	 * subjectId of Faculty
	 */
	@NotNull
	private Long subjectId;
	/**
	 * subjectName of Faculty
	 */
	
	
	@NotEmpty
	private String qualification;
	/**
	 * emailId of Faculty
	 */
	@NotEmpty
	@Email
	private String emailId;

	/**
	 * Date of Birth of Faculty
	 */
	@NotEmpty
	private String dob;

	/**
	 * Gender Of Faculty
	 */
	@NotEmpty
	private String gender;

	/**
	 * Mobile Number of Faculty
	 */
	@NotEmpty
	
	private String mobileNo;

	/**
	 * accessor
	 */
	

	

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Override
	public BaseDTO getDto() {
		FacultyDTO dto = new FacultyDTO();

		dto.setId(id);
		dto.setCollegeId(collegeId);
		
		dto.setCourseId(courseId);
		
		dto.setDob(Util.getDate(dob));
		dto.setEmailId(emailId);
		dto.setFirstName(firstName);
		dto.setGender(gender);
		dto.setLastName(lastName);
		dto.setMobileNo(mobileNo);
		dto.setQualification(qualification);
		dto.setSubjectId(subjectId);
		
	

		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {

		FacultyDTO dto = (FacultyDTO) bDto;

		id = dto.getId();
		
		collegeId = dto.getCollegeId();
		
		courseId = dto.getCourseId();
		
		dob =Util.getDate(dto.getDob());
		emailId = dto.getEmailId();
		firstName = dto.getFirstName();
		gender = dto.getGender();
		lastName = dto.getLastName();
		mobileNo = dto.getMobileNo();
		qualification = dto.getQualification();
		subjectId = dto.getSubjectId();
		
		
		
		

	}
}
