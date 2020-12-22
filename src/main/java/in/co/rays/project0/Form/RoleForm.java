package in.co.rays.project0.Form;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.project0.DTO.BaseDTO;
import in.co.rays.project0.DTO.RoleDTO;


/**
 * Contains ROle form elements and their declarative input validations.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public class RoleForm extends BaseForm{
	
	@NotEmpty
    private String roleName;

    @NotEmpty
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

    @Override
    public BaseDTO getDto() {

        RoleDTO dto = new RoleDTO();
        dto.setId(id);
        dto.setRoleName(roleName);
        dto.setRoleDescription(roleDescription);
       
        return dto;
    }

    @Override
    public void populate(BaseDTO bDto) {

        if (bDto == null) {
            return;
        }

        RoleDTO dto = (RoleDTO) bDto;

        id = dto.getId();
        roleName = dto.getRoleName();
        roleDescription = dto.getRoleDescription();
     
    }


}
