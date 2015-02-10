package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;
public class McResultM implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mcId;
	private Integer mcScore;
	private Integer meId;
	private Integer mqId;
	private McCustomerAssessmentM mcCustomerAssessment;
	private Integer mcustAssessmentId;
	private String mdaHotlink;
	public McResultM() {
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