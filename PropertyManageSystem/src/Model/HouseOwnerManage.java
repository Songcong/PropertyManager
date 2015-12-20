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
 * HouseOwnerManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "house_owner_manage", catalog = "wygl")
public class HouseOwnerManage implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer manageId;
	@Label("房屋号")
	private Integer houseid;
	@Label("姓名")
	private String name;
	@Label("性别")
	private String sex;
	@Label("有效证件")
	private String documentation;
	@Label("原所在地")
	private String origin;
	@Label("购房时间")
	private Timestamp buytime;
	@Label("是否租借")
	private Integer rentstate;

	// Constructors

	/** default constructor */
	public HouseOwnerManage() {
	}

	/** full constructor */
	public HouseOwnerManage(Integer houseid, String name, String sex,
			String documentation, String origin, Timestamp buytime,
			Integer rentstate) {
		this.houseid = houseid;
		this.name = name;
		this.sex = sex;
		this.documentation = documentation;
		this.origin = origin;
		this.buytime = buytime;
		this.rentstate = rentstate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "manage_id", unique = true, nullable = false)
	public Integer getManageId() {
		return this.manageId;
	}

	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}

	@Column(name = "houseid")
	public Integer getHouseid() {
		return this.houseid;
	}

	public void setHouseid(Integer houseid) {
		this.houseid = houseid;
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

	@Column(name = "documentation", length = 100)
	public String getDocumentation() {
		return this.documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	@Column(name = "origin", length = 40)
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Column(name = "buytime", length = 19)
	public Timestamp getBuytime() {
		return this.buytime;
	}

	public void setBuytime(Timestamp buytime) {
		this.buytime = buytime;
	}

	@Column(name = "rentstate")
	public Integer getRentstate() {
		return this.rentstate;
	}

	public void setRentstate(Integer rentstate) {
		this.rentstate = rentstate;
	}

}