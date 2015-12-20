package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.Label;

/**
 * Stall entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stall", catalog = "wygl")
public class Stall implements java.io.Serializable {

	// Fields

	@Label("车位编号")
	private Integer stallId;
	@Label("车位位置")
	private String location;
	@Label("是否使用")
	private Integer isused;
	@Label("是否能用")
	private Integer isuse;

	// Constructors

	/** default constructor */
	public Stall() {
	}

	/** full constructor */
	public Stall(String location, Integer isused, Integer isuse) {
		this.location = location;
		this.isused = isused;
		this.isuse = isuse;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stall_id", unique = true, nullable = false)
	public Integer getStallId() {
		return this.stallId;
	}

	public void setStallId(Integer stallId) {
		this.stallId = stallId;
	}

	@Column(name = "location", length = 50)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "isused")
	public Integer getIsused() {
		return this.isused;
	}

	public void setIsused(Integer isused) {
		this.isused = isused;
	}

	@Column(name = "isuse")
	public Integer getIsuse() {
		return this.isuse;
	}

	public void setIsuse(Integer isuse) {
		this.isuse = isuse;
	}

}