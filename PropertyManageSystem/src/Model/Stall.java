package Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Stall entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stall", catalog = "wygl")
public class Stall implements java.io.Serializable {

	// Fields

	private Integer stallId;
	private String location;
	private Integer isused;
	private Integer isuse;
	private Set<Car> cars = new HashSet<Car>(0);

	// Constructors

	/** default constructor */
	public Stall() {
	}

	/** full constructor */
	public Stall(String location, Integer isused, Integer isuse, Set<Car> cars) {
		this.location = location;
		this.isused = isused;
		this.isuse = isuse;
		this.cars = cars;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stall")
	public Set<Car> getCars() {
		return this.cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}