package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import Anno.*;

/**
 * FamilyDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "family_detail", catalog = "wygl")
public class FamilyDetail implements java.io.Serializable {

	// Fields

	@Label("家庭编号")
	private Integer familyId;
	@Label("外部ID")
	private Integer foreignId;
	@Label("姓名")
	private String name;
	@Label("性别")
	private String sex;
	@Label("关系")
	private String relation;
	@Label("健康状况")
	private String health;


	// Constructors

	/** default constructor */
	public FamilyDetail() {
	}

	/** full constructor */
	public FamilyDetail(Integer foreignId, String name, String sex,
			String relation, String health) {
		this.foreignId = foreignId;
		this.name = name;
		this.sex = sex;
		this.relation = relation;
		this.health = health;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "family_id", unique = true, nullable = false)
	public Integer getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	@Column(name = "foreign_id")
	public Integer getForeignId() {
		return this.foreignId;
	}

	public void setForeignId(Integer foreignId) {
		this.foreignId = foreignId;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex", length = 10)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "relation", length = 30)
	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Column(name = "health", length = 100)
	public String getHealth() {
		return this.health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

}