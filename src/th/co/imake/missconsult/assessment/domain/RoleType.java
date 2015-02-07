package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the role_type database table.
 * 
 */
@Entity
@Table(name="role_type")
@NamedQuery(name="RoleType.findAll", query="SELECT r FROM RoleType r")
public class RoleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rt_id")
	private Integer rtId;

	private Integer order;

	private String role;

	@Column(name="role_desc")
	private String roleDesc;

	private String type;
    /*
	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="role_type_mappling"
		, joinColumns={
			@JoinColumn(name="rt_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<Role> roles;
    */
	public RoleType() {
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