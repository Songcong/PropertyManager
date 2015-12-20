package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import Anno.Label;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "car", catalog = "wygl")
public class Car implements java.io.Serializable {

	// Fields
	@Label("车辆号")
	private Integer carId;
	@Label("车位")
	private Integer stallId;
	@Label("车牌号")
	private String carnumber;
	@Label("车主")
	private String owner;
	@Label("联系方式")
	private String telnumber;
	@Label("其他时间")
	private String otherinfo;

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** full constructor */
	public Car(Integer stallId, String carnumber, String owner,
			String telnumber, String otherinfo) {
		this.stallId = stallId;
		this.carnumber = carnumber;
		this.owner = owner;
		this.telnumber = telnumber;
		this.otherinfo = otherinfo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "car_id", unique = true, nullable = false)
	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	@Column(name = "stall_id")
	public Integer getStallId() {
		return this.stallId;
	}

	public void setStallId(Integer stallId) {
		this.stallId = stallId;
	}

	@Column(name = "carnumber", length = 60)
	public String getCarnumber() {
		return this.carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	@Column(name = "owner", length = 50)
	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Column(name = "telnumber", length = 50)
	public String getTelnumber() {
		return this.telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	@Column(name = "otherinfo", length = 100)
	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

}