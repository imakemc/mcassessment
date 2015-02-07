package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;

public class McOrderForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer moId;
	private String moStatus;
	private McCustomerForm mcCustomer;
	private McSeryForm mcSery;

	public McOrderForm() {
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

	public McCustomerForm getMcCustomer() {
		return this.mcCustomer;
	}

	public void setMcCustomer(McCustomerForm mcCustomer) {
		this.mcCustomer = mcCustomer;
	}

	public McSeryForm getMcSery() {
		return this.mcSery;
	}

	public void setMcSery(McSeryForm mcSery) {
		this.mcSery = mcSery;
	}

}