package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.FK;
import Anno.Label;

/**
 * Charstan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "charstan", catalog = "wygl")
public class Charstan implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer stanId;
	@FK("expdetail")
	@Label("收费详细说明")
	private Integer expdetailId;
	@Label("描述")
	private String description;

	// Constructors

	/** default constructor */
	public Charstan() {
	}

	/** full constructor */
	public Charstan(Integer expdetailId, String description) {
		this.expdetailId = expdetailId;
		this.description = description;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stan_id", unique = true, nullable = false)
	public Integer getStanId() {
		return this.stanId;
	}

	public void setStanId(Integer stanId) {
		this.stanId = stanId;
	}

	@Column(name = "expdetail_id")
	public Integer getExpdetailId() {
		return this.expdetailId;
	}

	public void setExpdetailId(Integer expdetailId) {
		this.expdetailId = expdetailId;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}