package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;


public class UserForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String firstname;

	private String lastname;

	private String password;

	private String username;

	private RoleForm role;

	public UserForm() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public RoleForm getRole() {
		return this.role;
	}

	public void setRole(RoleForm role) {
		this.role = role;
	}

}