package in.co.rays.project0.Form;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contains Forget Password form elements and their declarative input
 * validations.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public class ForgetPasswordForm extends BaseForm {
	@NotEmpty
	@Email
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
