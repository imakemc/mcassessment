package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the MC_RESULT database table.
 * 
 */
@Embeddable
public class McResultPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MCUST_ASSESSMENT_ID", insertable=false, updatable=false)
	private Integer mcustAssessmentId;

	@Column(name="MDA_HOTLINK")
	private String mdaHotlink;

	public McResultPK() {
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