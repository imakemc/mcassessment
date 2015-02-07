package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the MC_RESULT database table.
 * 
 */
@Entity
@Table(name="MC_RESULT")
@NamedQuery(name="McResult.findAll", query="SELECT m FROM McResult m")
public class McResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private McResultPK id;

	@Column(name="MC_ID")
	private Integer mcId;

	@Column(name="MC_SCORE")
	private Integer mcScore;

	@Column(name="ME_ID")
	private Integer meId;

	@Column(name="MQ_ID")
	private Integer mqId;

	//bi-directional many-to-one association to McCustomerAssessment
	@ManyToOne
	@JoinColumn(name="MCUST_ASSESSMENT_ID")
	private McCustomerAssessment mcCustomerAssessment;

	public McResult() {
	}

	public McResultPK getId() {
		return this.id;
	}

	public void setId(McResultPK id) {
		this.id = id;
	}

	public Integer getMcId() {
		return this.mcId;
	}

	public void setMcId(Integer mcId) {
		this.mcId = mcId;
	}

	public Integer getMcScore() {
		return this.mcScore;
	}

	public void setMcScore(Integer mcScore) {
		this.mcScore = mcScore;
	}

	public Integer getMeId() {
		return this.meId;
	}

	public void setMeId(Integer meId) {
		this.meId = meId;
	}

	public Integer getMqId() {
		return this.mqId;
	}

	public void setMqId(Integer mqId) {
		this.mqId = mqId;
	}

	public McCustomerAssessment getMcCustomerAssessment() {
		return this.mcCustomerAssessment;
	}

	public void setMcCustomerAssessment(McCustomerAssessment mcCustomerAssessment) {
		this.mcCustomerAssessment = mcCustomerAssessment;
	}

}