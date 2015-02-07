package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;

public class McSeryForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer msId;
	private String msName;

	private Integer msUnit;
    
	private McDegreeForm mcDegree;
    
	public McSeryForm() {
	}

	public Integer getMsId() {
		return this.msId;
	}

	public void setMsId(Integer msId) {
		this.msId = msId;
	}

	public String getMsName() {
		return this.msName;
	}

	public void setMsName(String msName) {
		this.msName = msName;
	}

	public Integer getMsUnit() {
		return this.msUnit;
	}

	public void setMsUnit(Integer msUnit) {
		this.msUnit = msUnit;
	}


	
	

	public McDegreeForm getMcDegree() {
		return this.mcDegree;
	}

	public void setMcDegree(McDegreeForm mcDegree) {
		this.mcDegree = mcDegree;
	}

	

}