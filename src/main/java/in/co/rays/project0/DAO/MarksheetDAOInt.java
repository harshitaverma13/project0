package in.co.rays.project0.DAO;

import java.util.List;

import in.co.rays.project0.DTO.MarksheetDTO;


/**
 * Marksheet DAO interface.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public interface MarksheetDAOInt {
	 /**
     * Adds a Marksheet.
     * 
     * @param dto
     * @return
     */
    public long add(MarksheetDTO dto);

    /**
     * Updates a Marksheet.
     * 
     * @param dto
     * @return
     */
    public long update(MarksheetDTO dto);

    /**
     * Deletes a Marksheet.
     * 
     * @param id
     * 
     */
    public void delete(long id);

    /**
     * Finds Marskheet by Roll No.
     * 
     * @param rollNo
     * @return
     */
    public MarksheetDTO findByRollNo(String rollNo);

    /**
     * Finds Marksheet by Primary Key.
     * 
     * @param pk
     * @return
     */
    public MarksheetDTO findByPK(long pk);

    /**
     * Searches Marskheet.
     * 
     * @param dto
     * @return
     */
    public List search(MarksheetDTO dto);

    /**
     * Searches Marskheet with pagination.
     * 
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List search(MarksheetDTO dto, int pageNo, int pageSize);

    /**
     * Gets Merit List.
     * 
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List getMeritList(int pageNo, int pageSize);

}
