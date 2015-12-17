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

	private Integer stanId;
	private Expdetail expdetail;
	private String description;
	private Set<Expensetype> expensetypes = new HashSet<Expensetype>(0);

	// Constructors

	/** default constructor */
	public Charstan() {
	}

	/** full constructor */
	public Charstan(Expdetail expdetail, String description,
			Set<Expensetype> expensetypes) {
		this.expdetail = expdetail;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expdetail_id")
	public Expdetail getExpdetail() {
		return this.expdetail;
	}

	public void setExpdetail(Expdetail expdetail) {
		this.expdetail = expdetail;
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