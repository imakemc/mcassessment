package th.co.imake.missconsult.assessment.dto;

import java.io.Serializable;

public class McOrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer moId;
	private String moStatus;
	private McCustomerDTO mcCustomer;
	private McSeryDTO mcSery;

	public McOrderDTO() {
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

	public McCustomerDTO getMcCustomer() {
		return this.mcCustomer;
	}

	public void setMcCustomer(McCustomerDTO mcCustomer) {
		this.mcCustomer = mcCustomer;
	}

	public McSeryDTO getMcSery() {
		return this.mcSery;
	}

	public void setMcSery(McSeryDTO mcSery) {
		this.mcSery = mcSery;
	}

}