package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import Anno.*;

/**
 * Occupation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "occupation", catalog = "wygl")
public class Occupation implements java.io.Serializable {

	// Fields

	@Label("职位ID")
	private Integer occupationId;
	@Label("职位名")
	private String occupationname;
	@Label("工资")
	private String salary;
	@Label("描述")
	private String description;
	@Label("总需人数")
	private Integer headcount;
	@Label("在职人数")
	private Integer workcount;

	// Constructors

	/** default constructor */
	public Occupation() {
	}

	/** full constructor */
	public Occupation(String occupationname, String salary, String description,
			Integer headcount, Integer workcount) {
		this.occupationname = occupationname;
		this.salary = salary;
		this.description = description;
		this.headcount = headcount;
		this.workcount = workcount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "occupation_id", unique = true, nullable = false)
	public Integer getOccupationId() {
		return this.occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	@Column(name = "occupationname", length = 50)
	public String getOccupationname() {
		return this.occupationname;
	}

	public void setOccupationname(String occupationname) {
		this.occupationname = occupationname;
	}

	@Column(name = "salary", length = 50)
	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "headcount")
	public Integer getHeadcount() {
		return this.headcount;
	}

	public void setHeadcount(Integer headcount) {
		this.headcount = headcount;
	}

	@Column(name = "workcount")
	public Integer getWorkcount() {
		return this.workcount;
	}

	public void setWorkcount(Integer workcount) {
		this.workcount = workcount;
	}

}