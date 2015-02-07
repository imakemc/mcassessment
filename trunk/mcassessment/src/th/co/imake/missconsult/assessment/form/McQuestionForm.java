package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;
public class McQuestionForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mqId;
	private String maNameEng;
	private String mqNameThai;
	private McEvaluationForm mcEvaluation;

	public McQuestionForm() {
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

	public McEvaluationForm getMcEvaluation() {
		return this.mcEvaluation;
	}

	public void setMcEvaluation(McEvaluationForm mcEvaluation) {
		this.mcEvaluation = mcEvaluation;
	}

}