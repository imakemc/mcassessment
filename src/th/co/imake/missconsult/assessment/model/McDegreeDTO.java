package th.co.imake.missconsult.assessment.model;

import java.io.Serializable;


public class McDegreeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mdId;
	private String mdName;
	public McDegreeDTO() {
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
}