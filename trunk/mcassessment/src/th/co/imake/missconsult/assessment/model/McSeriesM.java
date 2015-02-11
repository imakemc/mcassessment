package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;

public class McSeriesM implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer msId;
	private String msName;

	private Integer msUnit;
    
	private McDegreeM mcDegree;
    
	public McSeriesM() {
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


	
	

	public McDegreeM getMcDegree() {
		return this.mcDegree;
	}

	public void setMcDegree(McDegreeM mcDegree) {
		this.mcDegree = mcDegree;
	}

	

}