package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the MC_CUSTOMER_ASSESSMENT database table.
 * 
 */
@Entity
@Table(name="MC_CUSTOMER_ASSESSMENT")
@NamedQuery(name="McCustomerAssessment.findAll", query="SELECT m FROM McCustomerAssessment m")
public class McCustomerAssessment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MCUST_ASSESSMENT_ID")
	private Integer mcustAssessmentId;

	@Column(name="MCUST_ASSESSMENT_AMOUNT_ASSESSOR_TOTAL")
	private Integer mcustAssessmentAmountAssessorTotal;

	@Column(name="MCUST_ASSESSMENT_AMOUNT_ASSESSOR_UESED")
	private Integer mcustAssessmentAmountAssessorUesed;

	@Column(name="MCUST_ASSESSMENT_STATUS")
	private String mcustAssessmentStatus;

	@Column(name="MCUST_EMPLOYEE")
	private String mcustEmployee;

	//bi-directional many-to-one association to McCustomer
	@ManyToOne
	@JoinColumn(name="MCUST_ID")
	private McCustomer mcCustomer;

	//bi-directional many-to-one association to McSery
	@ManyToOne
	@JoinColumn(name="MS_ID")
	private McSery mcSery;
    /*
	//bi-directional many-to-one association to McDoAssessment
	@OneToMany(mappedBy="mcCustomerAssessment")
	private List<McDoAssessment> mcDoAssessments;

	//bi-directional many-to-one association to McResult
	@OneToMany(mappedBy="mcCustomerAssessment")
	private List<McResult> mcResults;
	*/
	public McCustomerAssessment() {
	}

	public Integer getMcustAssessmentId() {
		return this.mcustAssessmentId;
	}

	public void setMcustAssessmentId(Integer mcustAssessmentId) {
		this.mcustAssessmentId = mcustAssessmentId;
	}

	public Integer getMcustAssessmentAmountAssessorTotal() {
		return this.mcustAssessmentAmountAssessorTotal;
	}

	public void setMcustAssessmentAmountAssessorTotal(Integer mcustAssessmentAmountAssessorTotal) {
		this.mcustAssessmentAmountAssessorTotal = mcustAssessmentAmountAssessorTotal;
	}

	public Integer getMcustAssessmentAmountAssessorUesed() {
		return this.mcustAssessmentAmountAssessorUesed;
	}

	public void setMcustAssessmentAmountAssessorUesed(Integer mcustAssessmentAmountAssessorUesed) {
		this.mcustAssessmentAmountAssessorUesed = mcustAssessmentAmountAssessorUesed;
	}

	public String getMcustAssessmentStatus() {
		return this.mcustAssessmentStatus;
	}

	public void setMcustAssessmentStatus(String mcustAssessmentStatus) {
		this.mcustAssessmentStatus = mcustAssessmentStatus;
	}

	public String getMcustEmployee() {
		return this.mcustEmployee;
	}

	public void setMcustEmployee(String mcustEmployee) {
		this.mcustEmployee = mcustEmployee;
	}

	public McCustomer getMcCustomer() {
		return this.mcCustomer;
	}

	public void setMcCustomer(McCustomer mcCustomer) {
		this.mcCustomer = mcCustomer;
	}

	public McSery getMcSery() {
		return this.mcSery;
	}

	public void setMcSery(McSery mcSery) {
		this.mcSery = mcSery;
	}
}