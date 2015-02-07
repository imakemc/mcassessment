package th.co.imake.missconsult.assessment.dto;

import java.io.Serializable;

public class McSeryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer msId;
	private String msName;

	private Integer msUnit;
    
	private McDegreeDTO mcDegree;
    
	public McSeryDTO() {
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


	
	

	public McDegreeDTO getMcDegree() {
		return this.mcDegree;
	}

	public void setMcDegree(McDegreeDTO mcDegree) {
		this.mcDegree = mcDegree;
	}

	

}