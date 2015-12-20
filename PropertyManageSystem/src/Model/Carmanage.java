package Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.Label;

/**
 * Carmanage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "carmanage", catalog = "wygl")
public class Carmanage implements java.io.Serializable {

	// Fields
	@Label("内部号")
	private Integer carmanageid;
	@Label("停车卡号")
	private String carid;
	@Label("停车时间")
	private Timestamp parttime;
	@Label("离开时间")
	private Timestamp leavetime;
	@Label("总收费")
	private String cost;
	@Label("车位ID")
	private Integer partid;

	// Constructors

	/** default constructor */
	public Carmanage() {
	}

	/** full constructor */
	public Carmanage(String carid, Timestamp parttime, Timestamp leavetime,
			String cost, Integer partid) {
		this.carid = carid;
		this.parttime = parttime;
		this.leavetime = leavetime;
		this.cost = cost;
		this.partid = partid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "carmanageid", unique = true, nullable = false)
	public Integer getCarmanageid() {
		return this.carmanageid;
	}

	public void setCarmanageid(Integer carmanageid) {
		this.carmanageid = carmanageid;
	}

	@Column(name = "carid", length = 50)
	public String getCarid() {
		return this.carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	@Column(name = "parttime", length = 19)
	public Timestamp getParttime() {
		return this.parttime;
	}

	public void setParttime(Timestamp parttime) {
		this.parttime = parttime;
	}

	@Column(name = "leavetime", length = 19)
	public Timestamp getLeavetime() {
		return this.leavetime;
	}

	public void setLeavetime(Timestamp leavetime) {
		this.leavetime = leavetime;
	}

	@Column(name = "cost", length = 50)
	public String getCost() {
		return this.cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Column(name = "partid")
	public Integer getPartid() {
		return this.partid;
	}

	public void setPartid(Integer partid) {
		this.partid = partid;
	}

}