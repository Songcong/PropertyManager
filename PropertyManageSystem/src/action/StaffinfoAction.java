package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Car;
import service.ICarService;

import javax.annotation.Resource;

@Action (value="carAction",results={
		@Result(name="list",type="redirectAction",location="carAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class CarAction {

	
	@Resource(name = "carService")
	private ICarService carService;
	
	
	private Car car;
	
	private String carId;
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	
	
	
	public String add(){
		carService.addoredit(car);
		return "list";
	}
	public String edit(){
		carService.addoredit(car);
		return "list";
	}
	public String delete(){
		carService.deletebyid(Integer.parseInt(carId));
		return "list";
	}
}
