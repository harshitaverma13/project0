package in.co.rays.project0.DAO;


import java.util.List;

import in.co.rays.project0.DTO.StudentDTO;

/**
 * 
 * Student DAO interface.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public interface StudentDAOInt {
	/**
     * Adds a Student
     */
    public long add(StudentDTO dto);

    /**
     * Updates a Student
     */
    public long update(StudentDTO dto) ;

    /**
     * Deletes a Student
     */
    public void delete(long id) ;

    /**
     * Finds Student by Email
     */
    public StudentDTO findByEmail(String email);

    /**
     * Finds Student by PK
     */
    public StudentDTO findByPK(long pk) ;

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
