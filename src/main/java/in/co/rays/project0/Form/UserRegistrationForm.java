package in.co.rays.project0.Form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.DTO.BaseDTO;
import in.co.rays.project0.DTO.UserDTO;
import in.co.rays.project0.Util.Util;


/* */
 
/**
 * Contains User Registration form elements and their declarative input
 * validations.
 *
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */


public class UserRegistrationForm extends BaseForm{

	@NotEmpty
    private String firstName;
    /**
     * Last Name of User
     */
    @NotEmpty
    private String lastName;

    @Email
    @NotEmpty
    private String emailId;
    /**
     * Password of User
     */
    @NotEmpty
    private String password;
    /**
     * confirm Password of User
     */
    @NotEmpty
    private String confirmPassword;


    /**
     * Date of Birth of User
     */
    @NotEmpty
    private String dob;

    /**
     * MobielNo of User
     */
    @NotEmpty
   
    private String mobileNo;

    /**
     * Gender of User
     */
    @NotEmpty
    private String gender;

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

    
    

    public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public BaseDTO getDto() {
        UserDTO dto = new UserDTO();

        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setLogin(emailId);
        dto.setPassword(password);
        dto.setConfirmPassword(confirmPassword);
        dto.setDob(Util.getDate(dob));
        dto.setMobileNo(mobileNo);
        dto.setGender(gender);
        return dto;
    }

    @Override
    public void populate(BaseDTO bDto) {
        UserDTO dto = (UserDTO) bDto;
        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        emailId = dto.getLogin();
        password = dto.getPassword();
        confirmPassword=dto.getConfirmPassword();
        dob = Util.getDate(dto.getDob());
        mobileNo = dto.getMobileNo();
        gender = dto.getGender();
    }
}
