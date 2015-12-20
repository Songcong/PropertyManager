package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.Label;

/**
 * UtilityDamage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "utility_damage", catalog = "wygl")
public class UtilityDamage implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer utilitydamageid;
	@Label("设备号")
	private Integer utilityid;
	@Label("使用说明")
	private String usecondition;
	@Label("损坏情况")
	private String damagecondition;

	// Constructors

	/** default constructor */
	public UtilityDamage() {
	}

	/** full constructor */
	public UtilityDamage(Integer utilityid, String usecondition,
			String damagecondition) {
		this.utilityid = utilityid;
		this.usecondition = usecondition;
		this.damagecondition = damagecondition;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "utilitydamageid", unique = true, nullable = false)
	public Integer getUtilitydamageid() {
		return this.utilitydamageid;
	}

	public void setUtilitydamageid(Integer utilitydamageid) {
		this.utilitydamageid = utilitydamageid;
	}

	@Column(name = "utilityid")
	public Integer getUtilityid() {
		return this.utilityid;
	}

	public void setUtilityid(Integer utilityid) {
		this.utilityid = utilityid;
	}

	@Column(name = "usecondition", length = 200)
	public String getUsecondition() {
		return this.usecondition;
	}

	public void setUsecondition(String usecondition) {
		this.usecondition = usecondition;
	}

	@Column(name = "damagecondition", length = 200)
	public String getDamagecondition() {
		return this.damagecondition;
	}

	public void setDamagecondition(String damagecondition) {
		this.damagecondition = damagecondition;
	}

}