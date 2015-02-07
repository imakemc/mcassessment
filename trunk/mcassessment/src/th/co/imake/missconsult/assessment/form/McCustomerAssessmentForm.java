package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;


public class McCustomerAssessmentForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mcustAssessmentId;
	private Integer mcustAssessmentAmountAssessorTotal;
	private Integer mcustAssessmentAmountAssessorUesed;
	private String mcustAssessmentStatus;
	private String mcustEmployee;
	private McCustomerForm mcCustomer;
	private McSeryForm mcSery;
	public McCustomerAssessmentForm() {
	}

	public Integer getMcustAssessmentId() {
		return this.mcustAssessmentId;
	}

	public void setMcustAssessmentId(Integer mcustAssessmentId) {
		this.mcustAssessmentId = mcustAssessmentId;
	}

	public Integer getMcustAssessmentAmountAssessorTotal() {
		return this.mcustAssessmentAmountAssessorTotal;
	}

	public void setMcustAssessmentAmountAssessorTotal(Integer mcustAssessmentAmountAssessorTotal) {
		this.mcustAssessmentAmountAssessorTotal = mcustAssessmentAmountAssessorTotal;
	}

	public Integer getMcustAssessmentAmountAssessorUesed() {
		return this.mcustAssessmentAmountAssessorUesed;
	}

	public void setMcustAssessmentAmountAssessorUesed(Integer mcustAssessmentAmountAssessorUesed) {
		this.mcustAssessmentAmountAssessorUesed = mcustAssessmentAmountAssessorUesed;
	}

	public String getMcustAssessmentStatus() {
		return this.mcustAssessmentStatus;
	}

	public void setMcustAssessmentStatus(String mcustAssessmentStatus) {
		this.mcustAssessmentStatus = mcustAssessmentStatus;
	}

	public String getMcustEmployee() {
		return this.mcustEmployee;
	}

	public void setMcustEmployee(String mcustEmployee) {
		this.mcustEmployee = mcustEmployee;
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