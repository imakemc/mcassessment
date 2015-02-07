package th.co.imake.missconsult.assessment.dto;

import java.io.Serializable;

public class McDegreeGroupDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mdgId;
	private String mdgName;
	private McDegreeDTO mcDegree;

	public McDegreeGroupDTO() {
	}

	public Integer getMdgId() {
		return this.mdgId;
	}

	public void setMdgId(Integer mdgId) {
		this.mdgId = mdgId;
	}

	public String getMdgName() {
		return this.mdgName;
	}

	public void setMdgName(String mdgName) {
		this.mdgName = mdgName;
	}

	public McDegreeDTO getMcDegree() {
		return this.mcDegree;
	}

	public void setMcDegree(McDegreeDTO mcDegree) {
		this.mcDegree = mcDegree;
	}

}