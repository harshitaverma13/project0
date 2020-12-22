package in.co.rays.project0.DAO;

import java.util.List;

import in.co.rays.project0.DTO.RoleDTO;


/**
 * 
 * Role DAO interface.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface RoleDAOInt {
	 /**
     * Adds a Role.
     * 
     * @param dto
     * @return
     */
    public long add(RoleDTO dto);

    /**
     * Updates a Role.
     * 
     * @param dto
     */
    public void update(RoleDTO dto);

    /**
     * Deletes a Role.
     * 
     * @param dto
     */
    public void delete(RoleDTO dto);

    /**
     * Finds Role by name.
     * 
     * @param roleName
     * @return
     */
    public RoleDTO findByName(String roleName);

    /**
     * Finds Role by Primary Key.
     * 
     * @param pk
     * @return
     */
    public RoleDTO findByPK(long pk);

    /**
     * Searches Role with pagination.
     * 
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List search(RoleDTO dto, int pageNo, int pageSize);

    /**
     * Seraches Role.
     * 
     * @param dto
     * @return
     */
    public List search(RoleDTO dto);

}
