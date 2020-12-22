package in.co.rays.project0.DAO;

import java.util.List;

import in.co.rays.project0.DTO.FacultyDTO;



/**
 * Service of Faculty
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public interface FacultyDAOInt {

	/**
     * Adds a Faculty
     * 
     * @param dto
     * 
     * 
     */

    public long add(FacultyDTO dto) ;

    /**
     * Deletes a Faculty
     * 
     * @param dto
     * @
     */
    public void delete(FacultyDTO dto) ;

    /**
     * Finds Faculty by Roll No
     * 
     * @param rollNo
     *            : get parameter
     * @return dto
     * @
     */
    public FacultyDTO findByEmailId(String Name) ;

    /**
     * Finds Faculty by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     * @
     */

    public FacultyDTO findByPK(long pk) ;

    /**
     * Updates a Faculty
     * 
     * @param dto
     * 
     */
    public long update(FacultyDTO dto);

    /**
     * Searches Faculty
     * 
     * @param dto
     *            : Search Parameters
     * 
     */
    public List search(FacultyDTO dto) ;

    /**
     * Searches Faculty with pagination
     * 
     * @return list : List of Facultys
     * @param dto
     *            : Search Parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     * 
     * 
     */
    public List search(FacultyDTO dto, int pageNo, int pageSize)
            ;

  

}
