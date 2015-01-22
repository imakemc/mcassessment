package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;

public class MyUser implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public MyUser(String fullName) {
		super();
		this.fullName = fullName;
	}

	private String fullName;
	private th.co.aoe.makedev.missconsult.xstream.MissContact missContact;

	public th.co.aoe.makedev.missconsult.xstream.MissContact getMissContact() {
		return missContact;
	}

	public void setMissContact(th.co.aoe.makedev.missconsult.xstream.MissContact missContact) {
		this.missContact = missContact;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
