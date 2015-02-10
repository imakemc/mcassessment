package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;

public class McDegreeGroupM implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mdgId;
	private String mdgName;
	private McDegreeM mcDegree;

	public McDegreeGroupM() {
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

	public McDegreeM getMcDegree() {
		return this.mcDegree;
	}

	public void setMcDegree(McDegreeM mcDegree) {
		this.mcDegree = mcDegree;
	}

}