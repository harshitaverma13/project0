package in.co.rays.project0.Form;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.project0.Util.DataValidator;

@Component
public class RoleValidator implements Validator{
	
	public boolean supports(Class<?> clazz) {
		return RoleForm.class.isAssignableFrom(clazz);
	}
	public void validate(Object target, Errors errors) {
		RoleForm roleForm=(RoleForm) target;
		String roleName=roleForm.getRoleName();
		

		if(!DataValidator.isNull(roleName)){
		if(!DataValidator.isName(roleName)){
			errors.rejectValue("roleName", "error.roleName.invalid");
		}else if(DataValidator.isWhiteSpace(roleName)){
			errors.rejectValue("roleName", "error.roleName.alfabet");
		}
		
	}
	
	}
}
