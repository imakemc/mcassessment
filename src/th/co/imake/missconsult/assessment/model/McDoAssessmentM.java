package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;

public class McDoAssessmentM implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mdaEmail;
	private String mdaName;
	private String mdaStatus;
	private McCustomerAssessmentM mcCustomerAssessment;
	private Integer mcustAssessmentId;
	private String mdaHotlink;
	public McDoAssessmentM() {
	}

	

	public String getMdaEmail() {
		return this.mdaEmail;
	}

	public void setMdaEmail(String mdaEmail) {
		this.mdaEmail = mdaEmail;
	}

	public String getMdaName() {
		return this.mdaName;
	}

	public void setMdaName(String mdaName) {
		this.mdaName = mdaName;
	}

	public String getMdaStatus() {
		return this.mdaStatus;
	}

	public void setMdaStatus(String mdaStatus) {
		this.mdaStatus = mdaStatus;
	}

	public McCustomerAssessmentM getMcCustomerAssessment() {
		return this.mcCustomerAssessment;
	}

	public void setMcCustomerAssessment(McCustomerAssessmentM mcCustomerAssessment) {
		this.mcCustomerAssessment = mcCustomerAssessment;
	}

	public Integer getMcustAssessmentId() {
		return mcustAssessmentId;
	}

	public void setMcustAssessmentId(Integer mcustAssessmentId) {
		this.mcustAssessmentId = mcustAssessmentId;
	}

	public String getMdaHotlink() {
		return mdaHotlink;
	}

	public void setMdaHotlink(String mdaHotlink) {
		this.mdaHotlink = mdaHotlink;
	}

}