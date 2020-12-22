package in.co.rays.project0.Service;

import java.util.List;

import in.co.rays.project0.DTO.MarksheetDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;


/**
 * Marksheet Service interface.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface MarksheetServiceInt {
	 /**
     * Adds a marksheet
     * 
     * @param dto
     * @return
     */
    public long add(MarksheetDTO dto) throws DuplicateRecordException;

    /**
     * updates Marksheet
     * 
     * @param dto
     * @return
     */
    public long update(MarksheetDTO dto) throws DuplicateRecordException;

    /**
     * Delets marksheet
     * 
     * @param id
     */
    public void delete(long id);

    /**
     * Finds marksheet by Roll No
     * 
     * @param rollNo
     * @return
     */
    public MarksheetDTO findByRollNo(String rollNo);

    /**
     * Finds Marksheet by PK
     * 
     * @param pk
     * @return
     */
    public MarksheetDTO findByPK(long pk);

    /**
     * Searches markhseet
     * 
     * @param dto
     * @return
     */
    public List search(MarksheetDTO dto);

    /**
     * Searches marksheet with pagination
     * 
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List search(MarksheetDTO dto, int pageNo, int pageSize);

    /**
     * Get merit list
     * 
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List getMeritList(int pageNo, int pageSize);

}


