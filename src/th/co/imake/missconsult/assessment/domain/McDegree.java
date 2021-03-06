package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the MC_DEGREE database table.
 * 
 */
@Entity
@Table(name="MC_DEGREE")
@NamedQuery(name="McDegree.findAll", query="SELECT m FROM McDegree m")
public class McDegree implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MD_ID")
	private Integer mdId;

	@Column(name="MD_NAME")
	private String mdName;
    /*
	//bi-directional many-to-one association to McDegreeGroup
	@OneToMany(mappedBy="mcDegree")
	private List<McDegreeGroup> mcDegreeGroups;

	//bi-directional many-to-one association to McSery
	@OneToMany(mappedBy="mcDegree")
	private List<McSery> mcSeries;
  */
//	@OneToMany(fetch=FetchType.LAZY)
//	@OneToMany(mappedBy="mcDegree",fetch=FetchType.LAZY)
//	private List<McDegreeGroup> mcDegreeGroups;
//	@OneToMany(mappedBy="mdiD")
	@OneToMany(targetEntity=McDegreeGroup.class,mappedBy="mcdegree",cascade={CascadeType.ALL},orphanRemoval=true)
	private List<McDegreeGroup> mcDegreeGroups;
	
	public McDegree() {
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

//C
	
}