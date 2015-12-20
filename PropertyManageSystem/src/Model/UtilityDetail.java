package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.*;

/**
 * UtilityDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "utility_detail", catalog = "wygl")
public class UtilityDetail implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer utilityId;
	@Label("设备管理ID")
	private Integer utilityManageId;
	@Label("设备说明")
	private String utilityinfo;
	@Label("购买地点")
	private String buyplace;
	@Label("购买说明")
	private String buyinfo;
	@Label("使用说明")
	private String userinfo;
	@Label("标记")
	private Integer flag;

	// Constructors

	/** default constructor */
	public UtilityDetail() {
	}

	/** full constructor */
	public UtilityDetail(Integer utilityManageId, String utilityinfo,
			String buyplace, String buyinfo, String userinfo, Integer flag) {
		this.utilityManageId = utilityManageId;
		this.utilityinfo = utilityinfo;
		this.buyplace = buyplace;
		this.buyinfo = buyinfo;
		this.userinfo = userinfo;
		this.flag = flag;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "utility_id", unique = true, nullable = false)
	public Integer getUtilityId() {
		return this.utilityId;
	}

	public void setUtilityId(Integer utilityId) {
		this.utilityId = utilityId;
	}

	@Column(name = "utility_manage_id")
	public Integer getUtilityManageId() {
		return this.utilityManageId;
	}

	public void setUtilityManageId(Integer utilityManageId) {
		this.utilityManageId = utilityManageId;
	}

	@Column(name = "utilityinfo", length = 200)
	public String getUtilityinfo() {
		return this.utilityinfo;
	}

	public void setUtilityinfo(String utilityinfo) {
		this.utilityinfo = utilityinfo;
	}

	@Column(name = "buyplace", length = 100)
	public String getBuyplace() {
		return this.buyplace;
	}

	public void setBuyplace(String buyplace) {
		this.buyplace = buyplace;
	}

	@Column(name = "buyinfo", length = 200)
	public String getBuyinfo() {
		return this.buyinfo;
	}

	public void setBuyinfo(String buyinfo) {
		this.buyinfo = buyinfo;
	}

	@Column(name = "userinfo", length = 200)
	public String getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "flag")
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}