package in.co.rays.project0.Form;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.project0.Util.DataValidator;

@Component
public class CollegeValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return CollegeForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		CollegeForm collegeForm = (CollegeForm) target;
		String name=collegeForm.getName();
		String address=collegeForm.getAddress();
		
		String state=collegeForm.getState();
		String city=collegeForm.getCity();
		String phoneNo=collegeForm.getPhoneNo();
		
		if (!DataValidator.isNull(name)) {
			if (!DataValidator.isName(name)) {
				errors.rejectValue("name" ,"error.name.invalid");
			}
		}
		if (!DataValidator.isNull(address)) {
			if (!DataValidator.isName(address)) {
				errors.rejectValue("address" ,"error.address.invalid");
			}
		}
		
		if (!DataValidator.isNull(state)) {
			if (!DataValidator.isName(state)) {
				errors.rejectValue("state" ,"error.state.invalid");
			}
		}
		
		if (!DataValidator.isNull(city)) {
			if (!DataValidator.isName(city)) {
				errors.rejectValue("city" ,"error.city.invalid");
			}
		}
		if (!DataValidator.isNull(phoneNo)) {
			if (DataValidator.isName(phoneNo)) {
				errors.rejectValue("phoneNo" ,"error.phoneNo.invalid");
			}
		}
		
	}
}
