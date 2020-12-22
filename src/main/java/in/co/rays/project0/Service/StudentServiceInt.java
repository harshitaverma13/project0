package in.co.rays.project0.Service;

import java.util.List;

import in.co.rays.project0.DTO.StudentDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;

/**
 * Student Service interface.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface StudentServiceInt {
	/**
     * Adds a Student
     * 
     * @param dto
     * @return
     */
    public long add(StudentDTO dto)throws DuplicateRecordException;

    /**
     * Updates a Student
     * 
     * @param dto
     * @return
     */
    public long update(StudentDTO dto)throws DuplicateRecordException;

    /**
     * Deletes a Student
     * 
     * @param id
     */
    public void delete(long id);

    /**
     * Finds Student by Email
     * 
     * @param email
     * @return
     */
    public StudentDTO findByEmail(String email);

    /**
     * Finds Student by PK
     * 
     * @param pk
     * @return
     */
    public StudentDTO findByPK(long pk);

    /**
     * Searches Students with pagination
     * 
     * @return list : List of Students
     * @param dto
     *            : Search Parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     */
    public List search(StudentDTO dto, int pageNo, int pageSize);

    /**
     * Searches Students
     * 
     * @return list : List of Students
     * @param dto
     *            : Search Parameters
     */
    public List search(StudentDTO dto);

}
