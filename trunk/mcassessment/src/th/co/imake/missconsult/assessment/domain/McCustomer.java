package th.co.imake.missconsult.assessment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the MC_CUSTOMER database table.
 * 
 */
@Entity
@Table(name="MC_CUSTOMER")
@NamedQuery(name="McCustomer.findAll", query="SELECT m FROM McCustomer m")
public class McCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MCUST_ID")
	private Integer mcustId;

	@Column(name="MCUST_HR_USER_ID")
	private String mcustHrUserId;

	@Column(name="MCUST_NAME")
	private String mcustName;

	@Column(name="MCUST_UNIT")
	private Integer mcustUnit;
	/*
	//bi-directional many-to-one association to McCustomerAssessment
	@OneToMany(mappedBy="mcCustomer")
	private List<McCustomerAssessment> mcCustomerAssessments;

	//bi-directional many-to-one association to McOrder
	@OneToMany(mappedBy="mcCustomer")
	private List<McOrder> mcOrders;
	 */
	public McCustomer() {
	}

	public Integer getMcustId() {
		return this.mcustId;
	}

	public void setMcustId(Integer mcustId) {
		this.mcustId = mcustId;
	}

	public String getMcustHrUserId() {
		return this.mcustHrUserId;
	}

	public void setMcustHrUserId(String mcustHrUserId) {
		this.mcustHrUserId = mcustHrUserId;
	}

	public String getMcustName() {
		return this.mcustName;
	}

	public void setMcustName(String mcustName) {
		this.mcustName = mcustName;
	}

	public Integer getMcustUnit() {
		return this.mcustUnit;
	}

	public void setMcustUnit(Integer mcustUnit) {
		this.mcustUnit = mcustUnit;
	}

	/*public List<McCustomerAssessment> getMcCustomerAssessments() {
		return this.mcCustomerAssessments;
	}

	public void setMcCustomerAssessments(List<McCustomerAssessment> mcCustomerAssessments) {
		this.mcCustomerAssessments = mcCustomerAssessments;
	}

	public McCustomerAssessment addMcCustomerAssessment(McCustomerAssessment mcCustomerAssessment) {
		getMcCustomerAssessments().add(mcCustomerAssessment);
		mcCustomerAssessment.setMcCustomer(this);

		return mcCustomerAssessment;
	}

	public McCustomerAssessment removeMcCustomerAssessment(McCustomerAssessment mcCustomerAssessment) {
		getMcCustomerAssessments().remove(mcCustomerAssessment);
		mcCustomerAssessment.setMcCustomer(null);

		return mcCustomerAssessment;
	}
    */
	/*public List<McOrder> getMcOrders() {
		return this.mcOrders;
	}

	public void setMcOrders(List<McOrder> mcOrders) {
		this.mcOrders = mcOrders;
	}
*/
/*	public McOrder addMcOrder(McOrder mcOrder) {
		getMcOrders().add(mcOrder);
		mcOrder.setMcCustomer(this);

		return mcOrder;
	}

	public McOrder removeMcOrder(McOrder mcOrder) {
		getMcOrders().remove(mcOrder);
		mcOrder.setMcCustomer(null);

		return mcOrder;
	}
*/
}