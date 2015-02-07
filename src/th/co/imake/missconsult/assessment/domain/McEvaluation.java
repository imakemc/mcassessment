package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the MC_EVALUATION database table.
 * 
 */
@Entity
@Table(name="MC_EVALUATION")
@NamedQuery(name="McEvaluation.findAll", query="SELECT m FROM McEvaluation m")
public class McEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ME_ID")
	private Integer meId;

	private String MC_EVALUATIONcol;

	@Lob
	@Column(name="MC_INTRO")
	private String mcIntro;

	@Column(name="ME_NAME")
	private String meName;
	/*
	//bi-directional many-to-one association to McQuestion
	@OneToMany(mappedBy="mcEvaluation")
	private List<McQuestion> mcQuestions;

	//bi-directional many-to-many association to McSery
	@ManyToMany(mappedBy="mcEvaluations")
	private List<McSery> mcSeries;
	*/
	public McEvaluation() {
	}

	public Integer getMeId() {
		return this.meId;
	}

	public void setMeId(Integer meId) {
		this.meId = meId;
	}

	public String getMC_EVALUATIONcol() {
		return this.MC_EVALUATIONcol;
	}

	public void setMC_EVALUATIONcol(String MC_EVALUATIONcol) {
		this.MC_EVALUATIONcol = MC_EVALUATIONcol;
	}

	public String getMcIntro() {
		return this.mcIntro;
	}

	public void setMcIntro(String mcIntro) {
		this.mcIntro = mcIntro;
	}

	public String getMeName() {
		return this.meName;
	}

	public void setMeName(String meName) {
		this.meName = meName;
	}

	
}