package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.Label;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo", catalog = "wygl")
public class Userinfo implements java.io.Serializable {

	// Fields
	@Label("用户号")
	private Integer userid;
	@Label("用户名")
	private String username;
	@Label("密码")
	private String password;
	@Label("真名")
	private String realname;
	@Label("性别")
	private String sex;
	@Label("电话")
	private String telnumber;
	@Label("邮箱")
	private String email;
	@Label("地址")
	private String address;
	@Label("标记")
	private String tag;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(String username, String password, String realname,
			String sex, String telnumber, String email, String address,
			String tag) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.telnumber = telnumber;
		this.email = email;
		this.address = address;
		this.tag = tag;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return this.userid;
	}
	
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Column(name = "telnumber", length = 50)
	public String getTelnumber() {
		return this.telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "tag", length = 50)
	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}