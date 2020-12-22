package in.co.rays.project0.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Marksheet JavaBean encapsulates Marksheet attributes
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
@Entity
@Table(name = "ST_MARKSHEET")

public class MarksheetDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	/**
	 * ID of Student
	 */
	@Column(name = "STUDENTID")
	protected Long studentId;

	/**
	 * Rollno of Student
	 */
	@Column(name = "ROLLNO", length = 20)
	protected String rollNo = null;
	/**
	 * Name of Student
	 */
	@Column(name = "NAME", length = 50)
	protected String name = null;
	/**
	 * Physics marks of Student
	 */
	@Column(name = "PHYSICS")
	protected Integer physics;
	/**
	 * Chemistry marks of Student
	 */
	@Column(name = "CHEMISTRY")
	protected Integer chemistry;
	/**
	 * Mathematics marks of Student
	 */
	@Column(name = "MATHS")
	protected Integer maths;
	/**
	 * Total marks of Student
	 */
	@Column(name = "TOTAL")
	protected Integer total;

	/**
	 * accessor
	 */

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return rollNo;
	}

}