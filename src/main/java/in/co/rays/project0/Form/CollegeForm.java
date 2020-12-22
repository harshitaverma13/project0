package in.co.rays.project0.Form;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.DTO.BaseDTO;
import in.co.rays.project0.DTO.CollegeDTO;

/**
 * Contains College form elements and their declarative input validations.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public class CollegeForm extends BaseForm {
	/**
	 * Name of College
	 */
	@NotEmpty
	private String name;
	/**
	 * Address of College
	 */
	@NotEmpty
	private String address;
	/**
	 * State of College
	 */
	@NotEmpty
	private String state;
	/**
	 * City of College
	 */
	@NotEmpty
	private String city;
	/**
	 * Phoneno of College
	 */
	@NotEmpty
	
	private String phoneNo;

	/*
	 * Accesor Methods
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Populate dto from form
	 */
	@Override
	public BaseDTO getDto() {
		CollegeDTO dto = new CollegeDTO();

		dto.setId(id);
		dto.setName(name);
		dto.setAddress(address);
		dto.setState(state);
		dto.setCity(city);
		dto.setPhoneNo(phoneNo);

	
		return dto;
	}

	/**
	 * Populate from from dto
	 */
	@Override
	public void populate(BaseDTO bDto) {

		CollegeDTO dto = (CollegeDTO) bDto;

		id = dto.getId();
		name = dto.getName();
		address = dto.getAddress();
		city = dto.getCity();
		phoneNo = dto.getPhoneNo();
		state = dto.getState();


	}

}
