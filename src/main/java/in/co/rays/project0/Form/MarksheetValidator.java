package in.co.rays.project0.Form;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.project0.Util.DataValidator;
@Component

public class MarksheetValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		return MarksheetForm.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
	MarksheetForm marksheetForm = (MarksheetForm) target;
	
	String rollNo=marksheetForm.getRollNo();
	
	
	if (!DataValidator.isNull(rollNo)) {
		if (!DataValidator.isRollNo(rollNo)) {
			errors.rejectValue("rollNo" ,"error.rollNo.pattern");
		}
	}
	
	
	
	}

}
