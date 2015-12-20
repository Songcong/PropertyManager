package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.Label;


/**
 * HouseManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="house_manage"
    ,catalog="wygl"
)

public class HouseManage  implements java.io.Serializable {


    // Fields    

	@Label("房屋号")
	private Integer houseId;
	@Label("位置")
	private String location;
	@Label("面积")
	private String area;
	@Label("是否出售")
	private Integer sellstate;
	@Label("是否租借")
	private Integer rentstate;
	@Label("装修情况")
	private String fitmentinfo;


    // Constructors

    /** default constructor */
    public HouseManage() {
    }

    
    /** full constructor */
    public HouseManage(String location, String area, Integer sellstate, Integer rentstate, String fitmentinfo) {
        this.location = location;
        this.area = area;
        this.sellstate = sellstate;
        this.rentstate = rentstate;
        this.fitmentinfo = fitmentinfo;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="house_id", unique=true, nullable=false)

    public Integer getHouseId() {
        return this.houseId;
    }
    
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
    
    @Column(name="location", length=50)

    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    @Column(name="area", length=30)

    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    
    @Column(name="sellstate")

    public Integer getSellstate() {
        return this.sellstate;
    }
    
    public void setSellstate(Integer sellstate) {
        this.sellstate = sellstate;
    }
    
    @Column(name="rentstate")

    public Integer getRentstate() {
        return this.rentstate;
    }
    
    public void setRentstate(Integer rentstate) {
        this.rentstate = rentstate;
    }
    
    @Column(name="fitmentinfo", length=200)

    public String getFitmentinfo() {
        return this.fitmentinfo;
    }
    
    public void setFitmentinfo(String fitmentinfo) {
        this.fitmentinfo = fitmentinfo;
    }
   








}