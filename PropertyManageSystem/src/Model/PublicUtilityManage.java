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
 * PublicUtilityManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "public_utility_manage", catalog = "wygl")
public class PublicUtilityManage implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer utilityManageId;
	@Label("设备号")
	private Integer utilityid;
	@Label("购房时间")
	private Timestamp buytime;
	@Label("负责人")
	private String principal;
	@Label("位置")
	private String location;
	@Label("具体说明")
	private String utilitymanageinfo;

	// Constructors

	/** default constructor */
	public PublicUtilityManage() {
	}

	/** full constructor */
	public PublicUtilityManage(Integer utilityid, Timestamp buytime,
			String principal, String location, String utilitymanageinfo) {
		this.utilityid = utilityid;
		this.buytime = buytime;
		this.principal = principal;
		this.location = location;
		this.utilitymanageinfo = utilitymanageinfo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "utility_manage_id", unique = true, nullable = false)
	public Integer getUtilityManageId() {
		return this.utilityManageId;
	}

	public void setUtilityManageId(Integer utilityManageId) {
		this.utilityManageId = utilityManageId;
	}

	@Column(name = "utilityid")
	public Integer getUtilityid() {
		return this.utilityid;
	}

	public void setUtilityid(Integer utilityid) {
		this.utilityid = utilityid;
	}

	@Column(name = "buytime", length = 19)
	public Timestamp getBuytime() {
		return this.buytime;
	}

	public void setBuytime(Timestamp buytime) {
		this.buytime = buytime;
	}

	@Column(name = "principal", length = 30)
	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	@Column(name = "location", length = 50)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "utilitymanageinfo", length = 200)
	public String getUtilitymanageinfo() {
		return this.utilitymanageinfo;
	}

	public void setUtilitymanageinfo(String utilitymanageinfo) {
		this.utilitymanageinfo = utilitymanageinfo;
	}

}