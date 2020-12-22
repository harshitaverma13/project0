package in.co.rays.project0.DAO;

import java.util.List;

import in.co.rays.project0.DTO.SubjectDTO;





/**
 * Data Access Object of Subject
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public interface SubjectDAOInt {
	
	/**
     * Add a Subject
     * 
     * @param dto
     *
     */
    public long add(SubjectDTO dto) ;

    /**
     * Update a Subject
     * 
     * @param dto
    
     */
    public long update(SubjectDTO dto) ;

    /**
     * Delete a Subject
     * 
     * @param dto
     * @
     */
    public void delete(SubjectDTO dto);

    /**
     * Find Subject by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     * @
     */
    public SubjectDTO findByName(String name) ;

    /**
     * Find Subject by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     * @
     */
    public SubjectDTO findByPK(long pk) ;

    /**
     * Search Subject with pagination
     * 
     * @return list : List of Subject
     * @param dto
     *            : Search Parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     * @
     */
    public List search(SubjectDTO dto, int pageNo, int pageSize)
            ;

    /**
     * Search Subject
     * 
     * @return list : List of Subject
     * @param dto
     *            : Search Parameters
     * @
     */
    public List search(SubjectDTO dto) ;

    
}
