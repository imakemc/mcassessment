package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MC_DO_ASSESSMENT database table.
 * 
 */
@Entity
@Table(name="MC_DO_ASSESSMENT")
@NamedQuery(name="McDoAssessment.findAll", query="SELECT m FROM McDoAssessment m")
public class McDoAssessment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private McDoAssessmentPK id;

	@Column(name="MDA_EMAIL")
	private String mdaEmail;

	@Column(name="MDA_NAME")
	private String mdaName;

	@Column(name="MDA_STATUS")
	private String mdaStatus;

	//bi-directional many-to-one association to McCustomerAssessment
	@ManyToOne
	@JoinColumn(name="MCUST_ASSESSMENT_ID")
	private McCustomerAssessment mcCustomerAssessment;

	public McDoAssessment() {
	}

	public McDoAssessmentPK getId() {
		return this.id;
	}

	public void setId(McDoAssessmentPK id) {
		this.id = id;
	}

	public String getMdaEmail() {
		return this.mdaEmail;
	}

	public void setMdaEmail(String mdaEmail) {
		this.mdaEmail = mdaEmail;
	}

	public String getMdaName() {
		return this.mdaName;
	}

	public void setMdaName(String mdaName) {
		this.mdaName = mdaName;
	}

	public String getMdaStatus() {
		return this.mdaStatus;
	}

	public void setMdaStatus(String mdaStatus) {
		this.mdaStatus = mdaStatus;
	}

	public McCustomerAssessment getMcCustomerAssessment() {
		return this.mcCustomerAssessment;
	}

	public void setMcCustomerAssessment(McCustomerAssessment mcCustomerAssessment) {
		this.mcCustomerAssessment = mcCustomerAssessment;
	}

}