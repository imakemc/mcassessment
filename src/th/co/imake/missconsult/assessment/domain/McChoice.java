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
 * The persistent class for the MC_CHOICE database table.
 * 
 */
@Entity
@Table(name="MC_CHOICE")
@NamedQuery(name="McChoice.findAll", query="SELECT m FROM McChoice m")
public class McChoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MC_ID")
	private Integer mcId;

	@Column(name="MC_SCORE")
	private Integer mcScore;

	@Column(name="MC_TEXT")
	private String mcText;

	//bi-directional many-to-one association to McQuestion
	@ManyToOne
	@JoinColumn(name="MQ_ID")
	private McQuestion mcQuestion;

	public McChoice() {
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

	public String getMcText() {
		return this.mcText;
	}

	public void setMcText(String mcText) {
		this.mcText = mcText;
	}

	public McQuestion getMcQuestion() {
		return this.mcQuestion;
	}

	public void setMcQuestion(McQuestion mcQuestion) {
		this.mcQuestion = mcQuestion;
	}

}