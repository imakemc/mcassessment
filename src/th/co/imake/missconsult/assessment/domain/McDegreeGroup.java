package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MC_DEGREE_GROUP database table.
 * 
 */
@Entity
@Table(name="MC_DEGREE_GROUP")
@NamedQuery(name="McDegreeGroup.findAll", query="SELECT m FROM McDegreeGroup m")
public class McDegreeGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MDG_ID")
	private Integer mdgId;

	@Column(name="MDG_NAME")
	private String mdgName;
	
	@Column(name="MDG_ASSESSOR")
	private Integer mdgAssessor;
	
	@ManyToOne(targetEntity=McDegree.class)
	@JoinColumn(name="MD_ID")
	McDegree mcdegree;
//	@Column(name="MD_ID")
//	private Integer mdiD;

	//bi-directional many-to-one association to McDegree
//	@ManyToOne(fetch=FetchType.LAZY)
//	@ManyToOne
//	@JoinColumn(name="MD_ID")
//	private McDegree mcDegree;

	public McDegreeGroup() {
	}

	public Integer getMdgId() {
		return this.mdgId;
	}

	public void setMdgId(Integer mdgId) {
		this.mdgId = mdgId;
	}

	public String getMdgName() {
		return this.mdgName;
	}

	public void setMdgName(String mdgName) {
		this.mdgName = mdgName;
	}

//	public McDegree getMcDegree() {
//		return this.mcDegree;
//	}
//
//	public void setMcDegree(McDegree mcDegree) {
//		this.mcDegree = mcDegree;
//	}

	public Integer getMdgAssessor() {
		return mdgAssessor;
	}

	public void setMdgAssessor(Integer mdgAssessor) {
		this.mdgAssessor = mdgAssessor;
	}

	public McDegree getMcdegree() {
		return mcdegree;
	}

	public void setMcdegree(McDegree mcdegree) {
		this.mcdegree = mcdegree;
	}

//	public Integer getMdiD() {
//		return mdiD;
//	}
//
//	public void setMdiD(Integer mdiD) {
//		this.mdiD = mdiD;
//	}


 
}