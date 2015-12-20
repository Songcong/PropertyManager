package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.Label;

/**
 * ForeignManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "foreign_manage", catalog = "wygl")
public class ForeignManage implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer foreignId;
	@Label("性名")
	private String name;
	@Label("性别")
	private String sex;
	@Label("联系方式")
	private String phone;
	@Label("有效证件")
	private String documentation;
	@Label("家庭情况")
	private String family;
	@Label("居住情况")
	private String liveinformation;
	@Label("原所在地")
	private String origin;

	// Constructors

	/** default constructor */
	public ForeignManage() {
	}

	/** full constructor */
	public ForeignManage(String name, String sex, String phone,
			String documentation, String family, String liveinformation,
			String origin) {
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.documentation = documentation;
		this.family = family;
		this.liveinformation = liveinformation;
		this.origin = origin;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "foreign_id", unique = true, nullable = false)
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

	@Column(name = "phone", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "documentation", length = 100)
	public String getDocumentation() {
		return this.documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	@Column(name = "family", length = 30)
	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "liveinformation", length = 300)
	public String getLiveinformation() {
		return this.liveinformation;
	}

	public void setLiveinformation(String liveinformation) {
		this.liveinformation = liveinformation;
	}

	@Column(name = "origin", length = 40)
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}