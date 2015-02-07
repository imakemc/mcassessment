package th.co.imake.missconsult.assessment.dto;

import java.io.Serializable;


public class McCustomerAssessmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mcustAssessmentId;
	private Integer mcustAssessmentAmountAssessorTotal;
	private Integer mcustAssessmentAmountAssessorUesed;
	private String mcustAssessmentStatus;
	private String mcustEmployee;
	private McCustomerDTO mcCustomer;
	private McSeryDTO mcSery;
	public McCustomerAssessmentDTO() {
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