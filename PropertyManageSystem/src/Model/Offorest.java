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
 * Offorest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "offorest", catalog = "wygl")
public class Offorest implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer afforestId;
	@Label("绿化时间")
	private Timestamp afforesttime;
	@Label("绿化地点")
	private String afforestplace;
	@Label("参与人员")
	private String people;
	@Label("删除标记")
	private Integer deleted;

	// Constructors

	/** default constructor */
	public Offorest() {
	}

	/** full constructor */
	public Offorest(Timestamp afforesttime, String afforestplace,
			String people, Integer deleted) {
		this.afforesttime = afforesttime;
		this.afforestplace = afforestplace;
		this.people = people;
		this.deleted = deleted;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "afforest_id", unique = true, nullable = false)
	public Integer getAfforestId() {
		return this.afforestId;
	}

	public void setAfforestId(Integer afforestId) {
		this.afforestId = afforestId;
	}

	@Column(name = "afforesttime", length = 19)
	public Timestamp getAfforesttime() {
		return this.afforesttime;
	}

	public void setAfforesttime(Timestamp afforesttime) {
		this.afforesttime = afforesttime;
	}

	@Column(name = "afforestplace", length = 100)
	public String getAfforestplace() {
		return this.afforestplace;
	}

	public void setAfforestplace(String afforestplace) {
		this.afforestplace = afforestplace;
	}

	@Column(name = "people", length = 60)
	public String getPeople() {
		return this.people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	@Column(name = "deleted")
	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}