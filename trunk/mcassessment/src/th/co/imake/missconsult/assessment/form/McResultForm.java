package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;
public class McResultForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private McResultPKForm id;
	private Integer mcId;
	private Integer mcScore;
	private Integer meId;
	private Integer mqId;
	private McCustomerAssessmentForm mcCustomerAssessment;

	public McResultForm() {
	}

	public McResultPKForm getId() {
		return this.id;
	}

	public void setId(McResultPKForm id) {
		this.id = id;
	}

	public Integer getMcId() {
		return this.mcId;
	}

	public void setMcId(Integer mcId) {
		this.mcId = mcId;
	}

	public Integer getMcScore() {
		return this.mcScore;
	}

	public void setMcScore(Integer mcScore) {
		this.mcScore = mcScore;
	}

	public Integer getMeId() {
		return this.meId;
	}

	public void setMeId(Integer meId) {
		this.meId = meId;
	}

	public Integer getMqId() {
		return this.mqId;
	}

	public void setMqId(Integer mqId) {
		this.mqId = mqId;
	}

	public McCustomerAssessmentForm getMcCustomerAssessment() {
		return this.mcCustomerAssessment;
	}

	public void setMcCustomerAssessment(McCustomerAssessmentForm mcCustomerAssessment) {
		this.mcCustomerAssessment = mcCustomerAssessment;
	}

}