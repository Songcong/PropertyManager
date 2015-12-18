package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Expensetype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "expensetype", catalog = "wygl")
public class Expensetype implements java.io.Serializable {

	// Fields
	@Label("收费种类编号")
	private Integer expenseId;
	@Label("种类标准")
	private Charstan charstan;
	@Label("种类名称")
	private String expensename;
	@Label("收费标准ID")
	private Integer charstanid;
	@Label("收费说明")
	private String expenseinfo;

	// Constructors

	/** default constructor */
	public Expensetype() {
	}

	/** full constructor */
	public Expensetype(Charstan charstan, String expensename,
			Integer charstanid, String expenseinfo) {
		this.charstan = charstan;
		this.expensename = expensename;
		this.charstanid = charstanid;
		this.expenseinfo = expenseinfo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "expense_id", unique = true, nullable = false)
	public Integer getExpenseId() {
		return this.expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stan_id")
	public Charstan getCharstan() {
		return this.charstan;
	}

	public void setCharstan(Charstan charstan) {
		this.charstan = charstan;
	}

	@Column(name = "expensename", length = 50)
	public String getExpensename() {
		return this.expensename;
	}

	public void setExpensename(String expensename) {
		this.expensename = expensename;
	}

	@Column(name = "charstanid")
	public Integer getCharstanid() {
		return this.charstanid;
	}

	public void setCharstanid(Integer charstanid) {
		this.charstanid = charstanid;
	}

	@Column(name = "expenseinfo", length = 400)
	public String getExpenseinfo() {
		return this.expenseinfo;
	}

	public void setExpenseinfo(String expenseinfo) {
		this.expenseinfo = expenseinfo;
	}

}