

package in.co.rays.project0.Form;




import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contains login form elements and their declarative input validations.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public class LoginForm extends BaseForm {
	
	@NotEmpty             /*must be Email    EmailId is required.  Email should be an email id.*/
	@Email 
	/*@Pattern(regexp="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
	          + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
              + "(\\.[A-Za-z]{2,})$",message="EmailId is required.")*/
	private String emailId;

	@NotEmpty
     private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
