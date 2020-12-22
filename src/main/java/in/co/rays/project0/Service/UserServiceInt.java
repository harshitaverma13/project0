package in.co.rays.project0.Service;

import java.util.List;

import in.co.rays.project0.DTO.RoleDTO;
import in.co.rays.project0.DTO.UserDTO;
import in.co.rays.project0.Exception.ApplicationException;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Exception.RecordNotFoundException;


/**
 * User Service interface.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public interface UserServiceInt {
	/**
     * Adds a user
     * 
     * @param dto
     */
    public long add(UserDTO dto) throws DuplicateRecordException;

    /**
     * Registers a user
     * 
     * @param dto
     * @throws ApplicationException
     */
    public long registerUser(UserDTO dto) throws DuplicateRecordException;

    /**
     * Updates a User
     * 
     * @param dto
     */
    public void update(UserDTO dto) throws DuplicateRecordException;

    /**
     * Deletes a user
     * 
     * @param dto
     */
    public void delete(long id);

    /**
     * Finds user by Login
     * 
     * @param login
     *            : get parameter
     * @return dto
     */
    public UserDTO findByLogin(String login);

    /**
     * Finds user by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     */
    public UserDTO findByPK(long pk) ;

    /**
     * Searches Users with pagination
     * 
     * @return list : List of Users
     * @param dto
     *            : Search Parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     */
    public List search(UserDTO dto, int pageNo, int pageSize) ;

    /**
     * Searches Users
     * 
     * @return list : List of Users
     * @param dto
     *            : Search Parameters
     */
    public List search(UserDTO dto);

    /**
     * Change Password By pk
     * 
     * @param pk
     *            ,oldPassword,newPassword : get parameter
     * @return dto
     */
    public boolean changePassword(Long id, String oldPassword,
            String newPassword)throws RecordNotFoundException, ApplicationException ,DuplicateRecordException ;

    /**
     * User Authentication
     * 
     * @return dto : Contains User's information
     * @param dto
     */
    public UserDTO authenticate(String login,String password)throws RecordNotFoundException ;

    /**
     * Lock User for certain time duration
     * 
     * @return boolean : true if success otherwise false
     * @param login
     *            : User Login
     */
    public boolean lock(String login);

    /**
     * Reset Password of User with auto generated Password
     * 
     * @return boolean : true if success otherwise false
     * @param login
     *            : User Login
     * @throws ApplicationException
     */
    public boolean resetPassword(String login) throws ApplicationException;

    /**
     * Send the password of User to his Email
     * 
     * @return boolean : true if success otherwise false
     * @param login
     *            : User Login
     * @throws ApplicationException
     */
    public boolean forgetPassword(String login) throws ApplicationException;

    /**
     * Get User Roles
     * 
     * @return RoleDTO : User Role
     * @param dto
     */
    public RoleDTO getRole(UserDTO dto);

    /**
     * Update User access
     * 
     * @return dto
     * @param dto
     * @throws ApplicationException
     */
    public UserDTO updateAccess(UserDTO dto);

}
