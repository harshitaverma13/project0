package in.co.rays.project0.Form;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.project0.Util.DataValidator;
@Component
public class CourseValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		return CourseForm.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
	CourseForm courseForm = (CourseForm) target;
	String name=courseForm.getName();
	
	if (!DataValidator.isNull(name)) {
		if (!DataValidator.isName(name)) {
			errors.rejectValue("name" ,"error.name.invalid");
		}
	}
	
	
	}
}
