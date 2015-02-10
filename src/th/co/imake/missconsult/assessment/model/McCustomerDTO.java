package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;


public class McCustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mcustId;
	private String mcustHrUserId;
	private String mcustName;
	private Integer mcustUnit;
	public McCustomerDTO() {
	}

	public Integer getMcustId() {
		return this.mcustId;
	}

	public void setMcustId(Integer mcustId) {
		this.mcustId = mcustId;
	}

	public String getMcustHrUserId() {
		return this.mcustHrUserId;
	}

	public void setMcustHrUserId(String mcustHrUserId) {
		this.mcustHrUserId = mcustHrUserId;
	}

	public String getMcustName() {
		return this.mcustName;
	}

	public void setMcustName(String mcustName) {
		this.mcustName = mcustName;
	}

	public Integer getMcustUnit() {
		return this.mcustUnit;
	}

	public void setMcustUnit(Integer mcustUnit) {
		this.mcustUnit = mcustUnit;
	}
}