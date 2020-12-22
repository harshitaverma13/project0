package in.co.rays.project0.Form;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.project0.Util.DataValidator;

@Component
public class ChangePasswordValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		return ChangePasswordForm.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		ChangePasswordForm form = (ChangePasswordForm ) target;
		
		String newPassword = form.getNewPassword();
	    String confirmPassword = form.getConfirmPassword();
	    
	    if (!DataValidator.isNull(newPassword)) {
			if (!DataValidator.isPassword(newPassword)) {
				errors.rejectValue("newPassword", "error.password");
			}
		}

		if (!DataValidator.isNull(confirmPassword)) {
			if (!newPassword.equals(confirmPassword) && !"".equals(confirmPassword)) {
				errors.rejectValue("confirmPassword", "error.confirmPassword");
			}
		}
	
}}
