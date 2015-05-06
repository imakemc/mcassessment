package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;

public class McDegreeGroupForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mdgId;
	private String mdgName;
	private Integer mdgAssessor;
	private McDegreeForm mcDegree;

	public McDegreeGroupForm() {
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

	public McDegreeForm getMcDegree() {
		return this.mcDegree;
	}

	public void setMcDegree(McDegreeForm mcDegree) {
		this.mcDegree = mcDegree;
	}

	public Integer getMdgAssessor() {
		return mdgAssessor;
	}

	public void setMdgAssessor(Integer mdgAssessor) {
		this.mdgAssessor = mdgAssessor;
	}
 
}