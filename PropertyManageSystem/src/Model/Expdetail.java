package Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.FK;
import Anno.Label;

/**
 * Expdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "expdetail", catalog = "wygl")
public class Expdetail implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer expdetailId;
	@FK("expensetype")
	@Label("收费种类ID")
	private Integer expenseId;
	@Label("房屋号")
	private Integer houseid;
	@Label("是否缴费")
	private Integer state;
	@Label("收费人")
	private String chargepeople;
	@Label("收费时间")
	private Timestamp chargetime;
	@Label("删除标记")
	private Integer deleted;

	// Constructors

	/** default constructor */
	public Expdetail() {
	}

	/** full constructor */
	public Expdetail(Integer expenseid, Integer houseid, Integer state,
			String chargepeople, Timestamp chargetime, Integer deleted) {
		this.expenseId = expenseid;
		this.houseid = houseid;
		this.state = state;
		this.chargepeople = chargepeople;
		this.chargetime = chargetime;
		this.deleted = deleted;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "expdetail_id", unique = true, nullable = false)
	public Integer getExpdetailId() {
		return this.expdetailId;
	}

	public void setExpdetailId(Integer expdetailId) {
		this.expdetailId = expdetailId;
	}

	@Column(name = "expenseid")
	public Integer getExpenseId() {
		return this.expenseId;
	}

	public void setExpenseId(Integer expenseid) {
		this.expenseId = expenseid;
	}

	@Column(name = "houseid")
	public Integer getHouseid() {
		return this.houseid;
	}

	public void setHouseid(Integer houseid) {
		this.houseid = houseid;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "chargepeople", length = 50)
	public String getChargepeople() {
		return this.chargepeople;
	}

	public void setChargepeople(String chargepeople) {
		this.chargepeople = chargepeople;
	}

	@Column(name = "chargetime", length = 19)
	public Timestamp getChargetime() {
		return this.chargetime;
	}

	public void setChargetime(Timestamp chargetime) {
		this.chargetime = chargetime;
	}

	@Column(name = "deleted")
	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}