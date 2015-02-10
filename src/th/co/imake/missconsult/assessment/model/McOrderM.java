package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;

public class McOrderM implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer moId;
	private String moStatus;
	private McCustomerM mcCustomer;
	private McSeryM mcSery;

	public McOrderM() {
	}

	public Integer getMoId() {
		return this.moId;
	}

	public void setMoId(Integer moId) {
		this.moId = moId;
	}

	public String getMoStatus() {
		return this.moStatus;
	}

	public void setMoStatus(String moStatus) {
		this.moStatus = moStatus;
	}

	public McCustomerM getMcCustomer() {
		return this.mcCustomer;
	}

	public void setMcCustomer(McCustomerM mcCustomer) {
		this.mcCustomer = mcCustomer;
	}

	public McSeryM getMcSery() {
		return this.mcSery;
	}

	public void setMcSery(McSeryM mcSery) {
		this.mcSery = mcSery;
	}

}