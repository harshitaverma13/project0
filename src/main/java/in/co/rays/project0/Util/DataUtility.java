package in.co.rays.project0.Util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Data utility class to format data from one format to another
* @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public class DataUtility{
	/**
	 * Application date Format
	 */
	public static final String APP_DATE_FORMAT = "MM/dd/yyyy";
	public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	
	/**
	 * Date Formatter
	 */
	public static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);
	public static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);
	
	/**
	 * Trims leading and trailing spaces of a String
	 * @param val
	 * @return
	 */
	public static String getString(String val){
		if(DataValidator.isNotNull(val)){
			return val.trim();
		}
		else{
			return val;
		}
	}
	
	/**
	 * Converts an Object to String
	 * 
	 * @param val
	 * @return
	 */
	public static String getStringData(Object val){
		if(val!=null){
			return val.toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Converts a String into Integer
	 * 
	 * @param val
	 * @return
	 */
	public static int getInt(String val){
		if(DataValidator.isInteger(val)){
			return Integer.parseInt(val);
		}else{
			return 0;
		}
	}
	
	/**
	 * Converts a String into Long
	 * 
	 * @param val
	 * @return
	 */
	public static long getLong(String val){
		if(DataValidator.isLong(val)){
			return Long.parseLong(val);
		}else{
			return 0;
		}
	}
	/**
	 * Converts a String into Date
	 * 
	 * @param val
	 * @return
	 */
	public static Date getDate(String val){
		Date date = null;
		
		try{
			date = formatter.parse(val);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return date;
			
			
		}
		
		return date;
		
	}

	
	/**
	 * Converts Date into String
	 * 
	 * @param date
	 * @return
	 */
	
	public static String getDateString(Date date){
	  
		Date cd = new Date();
		/*try{
			if(date.compareTo(cd)<0){
				return formatter.format(date);
			}else{
				return null;
			}
		}catch(Exception e){
			return "";
		}*/
		
		try{
		     return formatter.format(date);
		    }catch(Exception e){
			return "";
		}
		
		
	}
	
	
	
	/**
	 * Converts String into Time
	 * 
	 * @param cdt
	 * @return
	 */
	public static Timestamp getTimestamp(long l) {

		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	public static Timestamp getTimestamp(String cdt) {

		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp((timeFormatter.parse(cdt)).getTime());
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	public static long getTimestamp(Timestamp tm) {
		try {
			return tm.getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	public static Timestamp getCurrentTimestamp() {
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(new Date().getTime());
		} catch (Exception e) {
		}
		return timeStamp;

	}
	
}	
		
		
		
		
		
		
	
