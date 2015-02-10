package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;


public class McCustomerAssessmentM implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mcustAssessmentId;
	private Integer mcustAssessmentAmountAssessorTotal;
	private Integer mcustAssessmentAmountAssessorUesed;
	private String mcustAssessmentStatus;
	private String mcustEmployee;
	private McCustomerM mcCustomer;
	private McSeryM mcSery;
	public McCustomerAssessmentM() {
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