package Model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Expdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "expdetail", catalog = "wygl")
public class Expdetail implements java.io.Serializable {

	// Fields

	private Integer expdetailId;
	private Integer expenseid;
	private Integer houseid;
	private Integer state;
	private String chargepeople;
	private Timestamp chargetime;
	private Integer deleted;
	private Set<Charstan> charstans = new HashSet<Charstan>(0);

	// Constructors

	/** default constructor */
	public Expdetail() {
	}

	/** full constructor */
	public Expdetail(Integer expenseid, Integer houseid, Integer state,
			String chargepeople, Timestamp chargetime, Integer deleted,
			Set<Charstan> charstans) {
		this.expenseid = expenseid;
		this.houseid = houseid;
		this.state = state;
		this.chargepeople = chargepeople;
		this.chargetime = chargetime;
		this.deleted = deleted;
		this.charstans = charstans;
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
	public Integer getExpenseid() {
		return this.expenseid;
	}

	public void setExpenseid(Integer expenseid) {
		this.expenseid = expenseid;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "expdetail")
	public Set<Charstan> getCharstans() {
		return this.charstans;
	}

	public void setCharstans(Set<Charstan> charstans) {
		this.charstans = charstans;
	}

}