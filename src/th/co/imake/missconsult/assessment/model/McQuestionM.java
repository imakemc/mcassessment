package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;
public class McQuestionM implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mqId;
	private String maNameEng;
	private String mqNameThai;
	private McEvaluationM mcEvaluation;

	public McQuestionM() {
	}

	public Integer getMqId() {
		return this.mqId;
	}

	public void setMqId(Integer mqId) {
		this.mqId = mqId;
	}

	public String getMaNameEng() {
		return this.maNameEng;
	}

	public void setMaNameEng(String maNameEng) {
		this.maNameEng = maNameEng;
	}

	public String getMqNameThai() {
		return this.mqNameThai;
	}

	public void setMqNameThai(String mqNameThai) {
		this.mqNameThai = mqNameThai;
	}

	public McEvaluationM getMcEvaluation() {
		return this.mcEvaluation;
	}

	public void setMcEvaluation(McEvaluationM mcEvaluation) {
		this.mcEvaluation = mcEvaluation;
	}

}