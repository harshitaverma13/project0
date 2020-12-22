package in.co.rays.project0.Service;
import java.util.List;

import in.co.rays.project0.DTO.FacultyDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;

/**
 * Faulty Service interface.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface FacultyServiceInt {
	/**
     * Adds a Faculty
     * 
     * @param dto
     * 
     * 
     */

    public long add(FacultyDTO dto) throws DuplicateRecordException ;

    /**
     * Deletes a Faculty
     * 
     * @param dto
     * @
     */
    public void delete(FacultyDTO dto)  throws DuplicateRecordException ;

    /**
     * Finds Faculty by Roll No
     * 
     * @param rollNo
     *            : get parameter
     * @return dto
     * @
     */
    public FacultyDTO findByEmailId(String email) ;

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
    public long update(FacultyDTO dto)throws DuplicateRecordException;

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
    public List search(FacultyDTO dto, int pageNo, int pageSize);

  



}
