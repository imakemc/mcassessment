package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;


public class McDegreeForm extends CommonForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mdId;
	private String mdName;
	public McDegreeForm() {
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