package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;

public class McDoAssessmentPKForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mcustAssessmentId;
	private String mdaHotlink;

	public McDoAssessmentPKForm() {
	}
	public Integer getMcustAssessmentId() {
		return this.mcustAssessmentId;
	}
	public void setMcustAssessmentId(Integer mcustAssessmentId) {
		this.mcustAssessmentId = mcustAssessmentId;
	}
	public String getMdaHotlink() {
		return this.mdaHotlink;
	}
	public void setMdaHotlink(String mdaHotlink) {
		this.mdaHotlink = mdaHotlink;
	}
}