package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;

public class McDoAssessmentForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private McDoAssessmentPKForm id;
	private String mdaEmail;
	private String mdaName;
	private String mdaStatus;
	private McCustomerAssessmentForm mcCustomerAssessment;

	public McDoAssessmentForm() {
	}

	public McDoAssessmentPKForm getId() {
		return this.id;
	}

	public void setId(McDoAssessmentPKForm id) {
		this.id = id;
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

	public McCustomerAssessmentForm getMcCustomerAssessment() {
		return this.mcCustomerAssessment;
	}

	public void setMcCustomerAssessment(McCustomerAssessmentForm mcCustomerAssessment) {
		this.mcCustomerAssessment = mcCustomerAssessment;
	}

}