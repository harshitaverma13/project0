package in.co.rays.project0.DAO;

import java.util.List;

import in.co.rays.project0.DTO.CourseDTO;



/**
 * Data Access Object of Course
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public interface CourseDAOInt {
	/**
	 * Add a Course
	 * 
	 * @param dto
	 * 
	 */
public long add(CourseDTO dto);

	/**
	 * Update a Course
	 * 
	 * @param dto
	 * 
	 */
	public long update(CourseDTO dto) ;

	/**
	 * Delete a Course
	 * 
	 * @param dto
	 * @
	 */
	public void delete(CourseDTO dto) ;

	/**
	 * Find Course by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @
	 */
	public CourseDTO findByName(String name) ;

	/**
	 * Find Course by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @
	 */
	public CourseDTO findByPK(long pk) ;

	/**
	 * Search Course with pagination
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize) ;

	/**
	 * Search Course
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters
	 * @
	 */
	public List search(CourseDTO dto) ;

	
}
