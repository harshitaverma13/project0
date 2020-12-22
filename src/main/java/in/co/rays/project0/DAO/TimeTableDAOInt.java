package in.co.rays.project0.DAO;

import java.util.Date;
import java.util.List;

import in.co.rays.project0.DTO.TimeTableDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;



/**
 * Service of TimeTable
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public interface TimeTableDAOInt {

	/**
     * Adds a TimeTable
     * 
     * @param dto
     
     */

    public long add(TimeTableDTO dto) ;

    /**
     * Deletes a TimeTable
     * 
     * @param dto
     * 
     */
    public void delete(TimeTableDTO dto) ;


    /**
     * Finds TimeTable by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     * 
     */

    public TimeTableDTO findByPK(long pk) ;

    /**
	 * Finds TimeTable by Course, Semester and Subject
	 * 
	 * @param courseId
	 *            : get Course Id
	 * @param subjectId
	 *            : get ID of Subject
	 * @return dto
	 * 
	 */
	public TimeTableDTO findByCourseAndSubAndSem(Long courseId, Long subjectId,String sem)  ;
	
	/**
	 * Finds TimeTable by Date and Course
	 * 
	 * @param examDate
	 *            : get Exam Date
	 * @param courseId
	 *            : get ID of Course
	 * @return dto
	 * 
	 */
	public TimeTableDTO findByDateAndCourseIdAndSem(Date examDate, Long courseId ,String sem) ;
    /**
     * Updates a TimeTable
     * 
     * @param dto
     * 
     * @throws DuplicateRecordException
     */
    public long update(TimeTableDTO dto) ;

    /**
     * Searches TimeTable
     * 
     * @param dto
     *            : Search Parameters
     * 
     */
    public List search(TimeTableDTO dto) ;

    /**
     * Searches TimeTable with pagination
     * 
     * @return list : List of TimeTable
     * @param dto
     *            : Search Parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     * 
     * 
     */
    public List search(TimeTableDTO dto, int pageNo, int pageSize);

    
}
