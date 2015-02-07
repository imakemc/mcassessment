package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;
public class McResultPKForm extends CommonForm implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer mcustAssessmentId;
	private String mdaHotlink;
	public McResultPKForm() {
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