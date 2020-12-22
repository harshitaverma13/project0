package in.co.rays.project0.Form;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.project0.Util.DataValidator;

@Component
public class SubjectValidator  implements Validator{
	public boolean supports(Class<?> clazz) {
		return SubjectForm.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
	SubjectForm subjectForm = (SubjectForm) target;
	String name=subjectForm.getName();
	
	if (!DataValidator.isNull(name)) {
		if (!DataValidator.isName(name)) {
			errors.rejectValue("name" ,"error.name.invalid");
		}
	}
	
	
	}
}
