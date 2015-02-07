package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;

public class McEvaluationForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer meId;
	private String MC_EVALUATIONcol;
	private String mcIntro;
	private String meName;
	public McEvaluationForm() {
	}

	public Integer getMeId() {
		return this.meId;
	}

	public void setMeId(Integer meId) {
		this.meId = meId;
	}

	public String getMC_EVALUATIONcol() {
		return this.MC_EVALUATIONcol;
	}

	public void setMC_EVALUATIONcol(String MC_EVALUATIONcol) {
		this.MC_EVALUATIONcol = MC_EVALUATIONcol;
	}

	public String getMcIntro() {
		return this.mcIntro;
	}

	public void setMcIntro(String mcIntro) {
		this.mcIntro = mcIntro;
	}

	public String getMeName() {
		return this.meName;
	}

	public void setMeName(String meName) {
		this.meName = meName;
	}

	
}