package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id")
	private Integer roleId;

	@Column(name="role_name")
	private String roleName;
	 /*
	//bi-directional many-to-many association to RoleType
	@ManyToMany(mappedBy="roles")
	private List<RoleType> roleTypes;
  
	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="role")
	private List<User> users;
*/
	public Role() {
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