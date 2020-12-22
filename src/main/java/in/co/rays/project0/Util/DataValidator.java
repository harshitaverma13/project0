package in.co.rays.project0.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class validates input data
 * 
* @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public class DataValidator {

	/**
	 * Checks if value is Null
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isName(String val) {

		String name = "^[a-zA-Z ]{2,}$";
		if (isNotNull(val)) {
			try {

				return val.matches(name);

			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isLname(String val) {

		String name = "^[a-zA-Z]{2,}$";
		if (isNotNull(val)) {
			try {

				return val.matches(name);

			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if value contains White Space
	 * 
	 * @param val
	 * @return boolean
	 */
	public static boolean isWhiteSpace(String val) {
		if (val.matches(".*\\s+.*")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if value contains special character
	 * 
	 * @param val
	 * @return boolean
	 */
	public static boolean isSpecial(String val) {
		String reg = "[A-Za-z0-9\\s]*";

		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if value contains any number
	 * 
	 * @param val
	 * @return boolean
	 */
	public static boolean isNumber(String val) {
		String reg = "[A-Za-z ~!@#$%^&*_=-|?/><.,]*";
		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean test(String val) {
		String test = "([a-zA-Z]+(\\.| |))*[a-zA-Z0-9]*";
		if (val.matches(test)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if value is valid Mobile Number
	 * 
	 * @param val
	 * @return boolean
	 */
	public static boolean isMob(String val) {

		String mo = "^[7-9][0-9]{9}$";

		if (val.matches(mo)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if value is Null
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isNameSpace(String val) {

		String name = "^[a-zA-Z][a-zA-Z ]{2,}$";
		if (isNotNull(val)) {
			try {

				return val.matches(name);

			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if value is a valid course name
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isCourseName(String val) {

		// String name = "^[a-zA-Z][ .a-zA-Z]{1,}$";
		String name = "([a-zA-Z]+(\\.| |))*[a-zA-Z]*";
		if (isNotNull(val)) {
			try {

				return val.matches(name);

			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks that value starts witn an alphabet and contains only alphabets and
	 * numbers
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isAlphanumericName(String val) {

		String name = "^[a-zA-Z][ .a-zA-Z]+[0-9]{0,2}$";
		if (isNotNull(val)) {
			try {

				return val.matches(name);

			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if value is a valid subject name
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isSubjectName(String val) {

		String name = "^[a-zA-Z][ .a-zA-Z0-9+# ]+$";
		if (isNotNull(val)) {
			try {

				return val.matches(name);

			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if value's length is between 6 and 12
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isPassword(String val) {
		if (val.length() >= 6 && val.length() <= 12) {
			return true;

		} else {
			return false;
		}
	}

	/**
	 * Checks if value is within the required marks range(0-100)
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isMarks(String val) {
		int marks = DataUtility.getInt(val);
		if (marks >= 0 && marks <= 100) {
			return true;

		} else {
			return false;
		}
	}
	/*
	 * public static boolean isState(String val) {
	 * 
	 * String name = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"; if (isNotNull(val)) {
	 * try {
	 * 
	 * return val.matches(name);
	 * 
	 * } catch (NumberFormatException e) { return false; } } else { return
	 * false; } }
	 */

	/**
	 * Checks if value is valid State Name
	 * 
	 * @param val
	 * @return boolean
	 */
	// old regex ([a-zA-Z]+(?:.|-| |'))*[a-zA-Z]*
	public static boolean isState(String val) {
		String reg = "([a-zA-Z]+(\\.| |))*[a-zA-Z]*";
		// [7-9][0-9]{9}$
		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if value is Null
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNull(String val) {
		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Checks if value is NOT Null
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNotNull(String val) {
		return !isNull(val);
	}

	/**
	 * Checks if value is an Integer
	 * 
	 * @param val
	 * @return
	 */

	/**
	 * Checks if value is a valid Integer value
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isInteger(String val) {

		if (isNotNull(val)) {
			try {
				int i = Integer.parseInt(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	/**
	 * Checks if value is Long
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isLong(String val) {
		try {
			long i = Long.parseLong(val);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	/**
	 * Checks if length is 10
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isLengthTen(String val) {
		try {
			if (val.length() == 10) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	/**
	 * Checks if value is valid Email ID
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isEmail(String val) {

		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (isNotNull(val)) {
			try {
				return val.matches(emailreg);
			} catch (Exception e) {
				return false;
			}

		} else {
			return false;
		}
	}

	/**
	 * Checks if value is Date
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isDate(String val) {

		Date d = null;
		if (isNotNull(val)) {
			d = DataUtility.getDate(val);
		}
		return d != null;
	}

	/**
	 * Checks if value is valid Date of Birth
	 * 
	 * @param val
	 * @return boolean
	 */
	public static boolean isDOB(String val) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date userDate = format.parse(val);
		Date todayDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(todayDate);
		cal.add(Calendar.YEAR, -17);

		Date beforedate = cal.getTime();
		if (beforedate.compareTo(userDate) == -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if value is a future date
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isFutureDate(Date val) {

		Date cd = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date td = new Date(formatter.format(cd));
		if (val.compareTo(td) < 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if given date is 17 years ago date.
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isGreater(Date date) {
		Date cd = new Date();
		boolean flag = true;

		int year = cd.getYear() - date.getYear();
		System.out.println(date);
		if ((cd.getMonth() - date.getMonth()) <= 0) {
			if ((cd.getDate() - date.getDate()) < 0)
				year--;
		}
		if (year < 17) {
			flag = false;
		}
		return flag;
	}

	/**
	 * Checks if it's sunday on the given date
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isSunday(Date date) {

		boolean flag = false;
		int day = date.getDay();
		if (day == 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Checks if value is a valid exam date
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isExamDate(String val) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date userDate = format.parse(val);
		Date todayDate = new Date();

		if (userDate.compareTo(todayDate) == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if value is a valid mobile number
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isMobileNo(String val) {
		String mobileRegex = "^[789][0-9]{9}$";
		if (val.matches(mobileRegex)) {
			return true;
		} else
			return false;
	}

	/**
	 * Checks if value is a valid roll number
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isRollNo(String val) {
		String rollRegex = "^[0-9]{4}+[a-zA-Z]{2}+[0-9]{3}";
		if (val.matches(rollRegex)) {
			return true;
		} else
			return false;
	}

	/**
	 * Checks if value is selected from a dropdown list
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isSelected(String val) {
		if (val.equalsIgnoreCase("select")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Test above methods
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isMobileNo("1234567abc"));

		/*
		 * System.out.println("Not Null 2" + isNotNull("ABC"));
		 * System.out.println("Not Null 3" + isNotNull(null));
		 * System.out.println("Not Null 4" + isNull("123"));
		 * 
		 * System.out.println("Is Int " + isInteger(null)); System.out.println(
		 * "Is Int " + isInteger("ABC1")); System.out.println("Is Int " +
		 * isInteger("123")); System.out.println("Is Int " + isNotNull("123"));
		 */
		System.out.println(isGreater(DataUtility.getDate("30/09/2016")));
		System.out.println("Is Roll " + isRollNo("1111aa111111"));
	}

}
