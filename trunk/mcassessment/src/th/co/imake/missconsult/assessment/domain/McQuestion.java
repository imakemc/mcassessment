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
 * The persistent class for the MC_QUESTION database table.
 * 
 */
@Entity
@Table(name="MC_QUESTION")
@NamedQuery(name="McQuestion.findAll", query="SELECT m FROM McQuestion m")
public class McQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MQ_ID")
	private Integer mqId;

	@Column(name="MA_NAME_ENG")
	private String maNameEng;

	@Column(name="MQ_NAME_THAI")
	private String mqNameThai;
	/*
	//bi-directional many-to-one association to McChoice
	@OneToMany(mappedBy="mcQuestion")
	private List<McChoice> mcChoices;
	 */
	//bi-directional many-to-one association to McEvaluation
	@ManyToOne
	@JoinColumn(name="ME_ID")
	private McEvaluation mcEvaluation;

	public McQuestion() {
	}

	public Integer getMqId() {
		return this.mqId;
	}

	public void setMqId(Integer mqId) {
		this.mqId = mqId;
	}

	public String getMaNameEng() {
		return this.maNameEng;
	}

	public void setMaNameEng(String maNameEng) {
		this.maNameEng = maNameEng;
	}

	public String getMqNameThai() {
		return this.mqNameThai;
	}

	public void setMqNameThai(String mqNameThai) {
		this.mqNameThai = mqNameThai;
	}

	public McEvaluation getMcEvaluation() {
		return this.mcEvaluation;
	}

	public void setMcEvaluation(McEvaluation mcEvaluation) {
		this.mcEvaluation = mcEvaluation;
	}

}