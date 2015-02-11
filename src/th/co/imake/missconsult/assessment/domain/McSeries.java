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
 * The persistent class for the MC_SERIES database table.
 * 
 */
@Entity
@Table(name="MC_SERIES")
@NamedQuery(name="McSery.findAll", query="SELECT m FROM McSery m")
public class McSeries implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MS_ID")
	private Integer msId;

	@Column(name="MS_NAME")
	private String msName;

	@Column(name="MS_UNIT")
	private Integer msUnit;
    /*
	//bi-directional many-to-one association to McCustomerAssessment
	@OneToMany(mappedBy="mcSery")
	private List<McCustomerAssessment> mcCustomerAssessments;

	//bi-directional many-to-one association to McOrder
	@OneToMany(mappedBy="mcSery")
	private List<McOrder> mcOrders;
    */
	//bi-directional many-to-one association to McDegree
	@ManyToOne
	@JoinColumn(name="MD_ID")
	private McDegree mcDegree;
    /*
	//bi-directional many-to-many association to McEvaluation
	@ManyToMany
	@JoinTable(
		name="MC_SERIES_MAPPING"
		, joinColumns={
			@JoinColumn(name="MS_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ME_ID")
			}
		)
	private List<McEvaluation> mcEvaluations;
   */
	public McSeries() {
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


	
	

	public McDegree getMcDegree() {
		return this.mcDegree;
	}

	public void setMcDegree(McDegree mcDegree) {
		this.mcDegree = mcDegree;
	}

	

}