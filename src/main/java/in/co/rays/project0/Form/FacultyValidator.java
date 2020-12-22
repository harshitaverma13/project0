package in.co.rays.project0.Form;
import java.text.ParseException;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.project0.Util.DataValidator;

@Component
public class FacultyValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return FacultyForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		FacultyForm form = (FacultyForm) target;
		String firstName = form.getFirstName();
		String lastName = form.getLastName();
		String qualification = form.getQualification();
		String dob = form.getDob();
		String mobileNo = form.getMobileNo();
		
		if (!DataValidator.isNull(firstName)) {
			if (!DataValidator.isName(firstName)) {
				errors.rejectValue("firstName" ,"error.firstName.invalid");
			}else if(DataValidator.isWhiteSpace(firstName)){
				errors.rejectValue("firstName", "error.firstName.alfabet");
				
			}
		}
		if (!DataValidator.isNull(lastName)) {
			if (!DataValidator.isName(lastName)) {
				errors.rejectValue("lastName" ,"error.lastName.invalid");
			}
			else if(DataValidator.isWhiteSpace(lastName)){
				errors.rejectValue("lastName", "error.lastName.alfabet");
				
			}
		}
		if (!DataValidator.isNull(qualification)) {
			if (!DataValidator.isName(qualification)) {
				errors.rejectValue("qualification" ,"error.qualification.invalid");
			}
		}
		if (!DataValidator.isNull(dob)) {
			try {
				if (!DataValidator.isDOB(dob)) {
					errors.rejectValue("dob", "error.dob");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!DataValidator.isNull(mobileNo)) {
			 if (!DataValidator.isMob(mobileNo)) {
				errors.rejectValue("mobileNo", "error.mobileNo.invalid");
			}
		}
		

	}
}
