package Model;

import Anno.Label;

/**
 * Occupation entity. @author MyEclipse Persistence Tools
 */

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

	public Integer getOccupationId() {
		return this.occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public String getOccupationname() {
		return this.occupationname;
	}

	public void setOccupationname(String occupationname) {
		this.occupationname = occupationname;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getHeadcount() {
		return this.headcount;
	}

	public void setHeadcount(Integer headcount) {
		this.headcount = headcount;
	}

	public Integer getWorkcount() {
		return this.workcount;
	}

	public void setWorkcount(Integer workcount) {
		this.workcount = workcount;
	}

}