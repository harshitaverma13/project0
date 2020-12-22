package in.co.rays.project0.Service;
import java.util.List;

import in.co.rays.project0.DTO.SubjectDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;

/**
 * Subject Service interface.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface SubjectServiceInt {

	/**
     * Add a Subject
     * 
     * @param dto
     *
     */
    public long add(SubjectDTO dto) throws DuplicateRecordException;

    /**
     * Update a Subject
     * 
     * @param dto
    
     */
    public long update(SubjectDTO dto) throws DuplicateRecordException;

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
