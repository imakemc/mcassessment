package th.co.imake.missconsult.assessment.dto;

import java.io.Serializable;
public class McQuestionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mqId;
	private String maNameEng;
	private String mqNameThai;
	private McEvaluationDTO mcEvaluation;

	public McQuestionDTO() {
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

	public McEvaluationDTO getMcEvaluation() {
		return this.mcEvaluation;
	}

	public void setMcEvaluation(McEvaluationDTO mcEvaluation) {
		this.mcEvaluation = mcEvaluation;
	}

}