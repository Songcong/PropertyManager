package Model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import Anno.*;

/**
 * Staffinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "staffinfo", catalog = "wygl")
public class Staffinfo implements java.io.Serializable {

	// Fields

	@Label("职员ID")
	private Integer staffId;
	@Label("职位ID")
	private Integer occupationId;
	@Label("真实姓名")
	private String realname;
	@Label("性别")
	private String sex;
	@Label("住址")
	private String address;
	@Label("邮箱")
	private String email;
	@Label("职业")
	private Integer occupationid;
	@Label("在职状态")
	private String workstate;
	@Label("入职时间")
	private Timestamp workstart;
	@Label("离职时间")
	private Timestamp workend;

	// Constructors

	/** default constructor */
	public Staffinfo() {
	}

	/** full constructor */
	public Staffinfo(Integer occupationId, String realname, String sex,
			String address, String email, Integer occupationid,
			String workstate, Timestamp workstart, Timestamp workend) {
		this.occupationId = occupationId;
		this.realname = realname;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.occupationid = occupationid;
		this.workstate = workstate;
		this.workstart = workstart;
		this.workend = workend;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "staff_id", unique = true, nullable = false)
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "occupation_id")
	public Integer getOccupationId() {
		return this.occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	@Column(name = "realname", length = 50)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "sex", length = 10)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "occupationid")
	public Integer getOccupationid() {
		return this.occupationid;
	}

	public void setOccupationid(Integer occupationid) {
		this.occupationid = occupationid;
	}

	@Column(name = "workstate", length = 20)
	public String getWorkstate() {
		return this.workstate;
	}

	public void setWorkstate(String workstate) {
		this.workstate = workstate;
	}

	@Column(name = "workstart", length = 19)
	public Timestamp getWorkstart() {
		return this.workstart;
	}

	public void setWorkstart(Timestamp workstart) {
		this.workstart = workstart;
	}

	@Column(name = "workend", length = 19)
	public Timestamp getWorkend() {
		return this.workend;
	}

	public void setWorkend(Timestamp workend) {
		this.workend = workend;
	}

}