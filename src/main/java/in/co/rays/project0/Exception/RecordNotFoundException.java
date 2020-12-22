package in.co.rays.project0.Exception;

/**
 * RecordNotFoundException thrown when a record not found occurred
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

public class RecordNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

    /**
     * @param msg
     *            error message
     */
    public RecordNotFoundException(String msg) {
        super(msg);

    }
}
