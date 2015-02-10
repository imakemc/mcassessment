package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;


public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer roleId;

	private String roleName;
	
	public RoleDTO() {
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}