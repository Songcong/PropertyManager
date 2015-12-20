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
 * Service entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "service", catalog = "wygl")
public class Service implements java.io.Serializable {

	// Fields

	@Label("内部号")
	private Integer serviceId;
	@Label("设施问题")
	private String facilitypro;
	@Label("装修地点")
	private String place;
	@Label("出现时间")
	private Timestamp starttime;
	@Label("是否解决")
	private String issolve;
	@Label("解决人")
	private String solvepeople;
	@Label("删除标记")
	private Integer deleted;

	// Constructors

	/** default constructor */
	public Service() {
	}

	/** full constructor */
	public Service(String facilitypro, String place, Timestamp starttime,
			String issolve, String solvepeople, Integer deleted) {
		this.facilitypro = facilitypro;
		this.place = place;
		this.starttime = starttime;
		this.issolve = issolve;
		this.solvepeople = solvepeople;
		this.deleted = deleted;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "service_id", unique = true, nullable = false)
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name = "facilitypro", length = 100)
	public String getFacilitypro() {
		return this.facilitypro;
	}

	public void setFacilitypro(String facilitypro) {
		this.facilitypro = facilitypro;
	}

	@Column(name = "place", length = 50)
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "starttime", length = 19)
	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	@Column(name = "issolve", length = 20)
	public String getIssolve() {
		return this.issolve;
	}

	public void setIssolve(String issolve) {
		this.issolve = issolve;
	}

	@Column(name = "solvepeople", length = 50)
	public String getSolvepeople() {
		return this.solvepeople;
	}

	public void setSolvepeople(String solvepeople) {
		this.solvepeople = solvepeople;
	}

	@Column(name = "deleted")
	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}