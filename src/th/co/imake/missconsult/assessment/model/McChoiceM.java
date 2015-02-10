package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;


public class McChoiceM implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mcId;
	private Integer mcScore;
	private String mcText;
	private McQuestionM mcQuestion;
	public McChoiceM() {
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

	public String getMcText() {
		return this.mcText;
	}

	public void setMcText(String mcText) {
		this.mcText = mcText;
	}

	public McQuestionM getMcQuestion() {
		return this.mcQuestion;
	}

	public void setMcQuestion(McQuestionM mcQuestion) {
		this.mcQuestion = mcQuestion;
	}

}