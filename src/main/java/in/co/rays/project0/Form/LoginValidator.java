package in.co.rays.project0.Form;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.project0.Util.DataValidator;


@Component
public class LoginValidator implements Validator{

	
	
	public boolean supports(Class<?> clazz) {
	
		return LoginForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		LoginForm form=(LoginForm) target;
		String emailId=form.getEmailId();
	
		/*if(!DataValidator.isNull(emailId)){
			if(!DataValidator.isEmail(emailId)){
				errors.rejectValue("emailId", "Email.form.emailId");
			}
		}*/
		
		}
		
}
