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
 * Fitment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fitment", catalog = "wygl")
public class Fitment implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer fitmentId;
	@Label("装修地点")
	private String place;
	@Label("拆迁地点")
	private String remove;
	@Label("装修时间")
	private Timestamp fitmenttime;
	@Label("装修类型")
	private Timestamp fitmenttype;

	// Constructors

	/** default constructor */
	public Fitment() {
	}

	/** full constructor */
	public Fitment(String place, String remove, Timestamp fitmenttime,
			Timestamp fitmenttype) {
		this.place = place;
		this.remove = remove;
		this.fitmenttime = fitmenttime;
		this.fitmenttype = fitmenttype;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "fitment_id", unique = true, nullable = false)
	public Integer getFitmentId() {
		return this.fitmentId;
	}

	public void setFitmentId(Integer fitmentId) {
		this.fitmentId = fitmentId;
	}

	@Column(name = "place", length = 50)
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "remove", length = 50)
	public String getRemove() {
		return this.remove;
	}

	public void setRemove(String remove) {
		this.remove = remove;
	}

	@Column(name = "fitmenttime", length = 19)
	public Timestamp getFitmenttime() {
		return this.fitmenttime;
	}

	public void setFitmenttime(Timestamp fitmenttime) {
		this.fitmenttime = fitmenttime;
	}

	@Column(name = "fitmenttype", length = 19)
	public Timestamp getFitmenttype() {
		return this.fitmenttype;
	}

	public void setFitmenttype(Timestamp fitmenttype) {
		this.fitmenttype = fitmenttype;
	}

}