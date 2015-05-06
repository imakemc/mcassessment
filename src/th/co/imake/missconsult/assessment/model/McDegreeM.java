package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;
import java.util.List;

import th.co.imake.missconsult.assessment.domain.McDegreeGroup;


public class McDegreeM implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mdId;
	private String mdName;
	private List<McDegreeGroup> mcDegreeGroups;
	public McDegreeM() {
	}

	public Integer getMdId() {
		return this.mdId;
	}

	public void setMdId(Integer mdId) {
		this.mdId = mdId;
	}

	public String getMdName() {
		return this.mdName;
	}

	public void setMdName(String mdName) {
		this.mdName = mdName;
	}

	public List<McDegreeGroup> getMcDegreeGroups() {
		return mcDegreeGroups;
	}

	public void setMcDegreeGroups(List<McDegreeGroup> mcDegreeGroups) {
		this.mcDegreeGroups = mcDegreeGroups;
	}
	
}