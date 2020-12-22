package in.co.rays.project0.Exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public class DuplicateRecordException extends Exception {

	/**
	 * @param msg
	 *            error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}

}