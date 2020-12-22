package in.co.rays.project0.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Role POJO class. It is persistent object.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Entity
@Table(name = "ST_ROLE")
public class RoleDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ADMIN = 1;
    public static final int STUDENT = 2;
    public static final int COLLEGE = 3;
    
   /* @Column(name = "NAME", length = 50)
    private String Name;

    @Column(name = "DESCRIPTION", length = 70)
    private String Description;*/

    @Column(name = "NAME", length = 50)
    private String roleName;

    @Column(name = "DESCRIPTION", length = 70)
    private String roleDescription;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getKey() {
        return String.valueOf(id);
    }

    public String getValue() {
        return roleName;
    }


}
