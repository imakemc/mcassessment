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
 * The persistent class for the MC_ORDER database table.
 * 
 */
@Entity
@Table(name="MC_ORDER")
@NamedQuery(name="McOrder.findAll", query="SELECT m FROM McOrder m")
public class McOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MO_ID")
	private Integer moId;

	@Column(name="MO_STATUS")
	private String moStatus;

	//bi-directional many-to-one association to McCustomer
	@ManyToOne
	@JoinColumn(name="MCUST_ID")
	private McCustomer mcCustomer;

	//bi-directional many-to-one association to McSery
	@ManyToOne
	@JoinColumn(name="MS_ID")
	private McSeries mcSery;

	public McOrder() {
	}

	public Integer getMoId() {
		return this.moId;
	}

	public void setMoId(Integer moId) {
		this.moId = moId;
	}

	public String getMoStatus() {
		return this.moStatus;
	}

	public void setMoStatus(String moStatus) {
		this.moStatus = moStatus;
	}

	public McCustomer getMcCustomer() {
		return this.mcCustomer;
	}

	public void setMcCustomer(McCustomer mcCustomer) {
		this.mcCustomer = mcCustomer;
	}

	public McSeries getMcSery() {
		return this.mcSery;
	}

	public void setMcSery(McSeries mcSery) {
		this.mcSery = mcSery;
	}

}