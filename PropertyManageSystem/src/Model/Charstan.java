package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Charstan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "charstan", catalog = "wygl")
public class Charstan implements java.io.Serializable {

	// Fields
	@Label("内部号")
	private Integer stanId;
	@Label("收费详细说明")
	private Integer expdetailId;
	@Label("描述")
	private String description;
	private Set<Expensetype> expensetypes = new HashSet<Expensetype>(0);

	// Constructors

	/** default constructor */
	public Charstan() {
	}

	/** full constructor */
	public Charstan(Integer expdetail, String description,
			Set<Expensetype> expensetypes) {
		this.expdetailId = expdetail;
		this.description = description;
		this.expensetypes = expensetypes;
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

	@Column(name = "expdetail_id", length = 11)
	public Integer getExpdetail() {
		return this.expdetailId;
	}

	public void setExpdetail(Integer expdetail) {
		this.expdetailId = expdetail;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "charstan")
	public Set<Expensetype> getExpensetypes() {
		return this.expensetypes;
	}

	public void setExpensetypes(Set<Expensetype> expensetypes) {
		this.expensetypes = expensetypes;
	}

}