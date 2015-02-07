package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;


public class RoleTypeForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer rtId;

	private Integer order;

	private String role;

	private String roleDesc;

	private String type;
   
	public RoleTypeForm() {
	}

	public Integer getRtId() {
		return this.rtId;
	}

	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}



}