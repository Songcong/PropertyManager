package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.Label;

/**
 * Jobtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jobtype", catalog = "wygl")
public class Jobtype implements java.io.Serializable {

	// Fields

	@Label("岗位种类ID")
	private Integer jobtypeId;
	@Label("岗位名称")
	private String jobname;
	@Label("岗位说明")
	private String jobinfo;
	@Label("所需人数")
	private Integer totalnum;
	@Label("在职人数")
	private Integer nownum;

	// Constructors

	/** default constructor */
	public Jobtype() {
	}

	/** full constructor */
	public Jobtype(String jobname, String jobinfo, Integer totalnum,
			Integer nownum) {
		this.jobname = jobname;
		this.jobinfo = jobinfo;
		this.totalnum = totalnum;
		this.nownum = nownum;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "jobtype_id", unique = true, nullable = false)
	public Integer getJobtypeId() {
		return this.jobtypeId;
	}

	public void setJobtypeId(Integer jobtypeId) {
		this.jobtypeId = jobtypeId;
	}

	@Column(name = "jobname", length = 50)
	public String getJobname() {
		return this.jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	@Column(name = "jobinfo", length = 200)
	public String getJobinfo() {
		return this.jobinfo;
	}

	public void setJobinfo(String jobinfo) {
		this.jobinfo = jobinfo;
	}

	@Column(name = "totalnum")
	public Integer getTotalnum() {
		return this.totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	@Column(name = "nownum")
	public Integer getNownum() {
		return this.nownum;
	}

	public void setNownum(Integer nownum) {
		this.nownum = nownum;
	}

}