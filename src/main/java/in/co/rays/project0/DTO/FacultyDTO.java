package in.co.rays.project0.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;




/**
 * Faculty JavaBean encapsulates Faculty attributes
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Entity
@Table(name="ST_FACULTY")
public class FacultyDTO extends BaseDTO {

	/**
	 * collegeId of Faculty
	 */
	@Column(name = "COLLEGEID")
	private Long collegeId;
	/**
	 * courseId of Faculty
	 */
	@Column(name = "COURSEID")
	private Long courseId;
	/**
	 * courseName of Faculty
	 */
	@Column(name = "COURSENAME", length = 50)
	private String courseName;
	/**
	 * firstName of Faculty
	 */
	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;
	/**
	 * lastName of Faculty
	 */
	@Column(name = "LAST_NAME", length = 50)
	private String lastName;
	/**
	 * subjectId of Faculty
	 */
	@Column(name = "SUBJECTID")
	private Long subjectId;
	/**
	 * subjectName of Faculty
	 */
	@Column(name = "SUBJECT", length = 50)
	private String subject;
	/**
	 * collegeName of Faculty
	 */
	@Column(name = "COLLEGE_NAME", length = 50)
	private String collegeName;
	/**
	 * qualification of Faculty
	 */
	@Column(name = "QUALIFICATION", length = 50)
	private String qualification;
	/**
	 * emailId of Faculty
	 */
	@Column(name = "EMAILID", length = 50)
	private String emailId;
	
	
	/**
	 * Date of Birth of Faculty
	 */
	@Column(name = "DOB")
	private Date dob;
	
	/**
	 * Gender Of Faculty
	 */
	@Column(name = "GENDER", length = 50)
	private String gender;

	/**
	 * Mobile Number of Faculty
	 */
	@Column(name = "MOBILENO", length = 50)
	private String mobileNo;

	
	
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

		public String getKey() {
		return id + "";
	}

	public String getValue() {
		return firstName + " " + lastName;
	}

}
