package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.ICarService;
import Model.Car;
import Utilx.ViewStringSet;
import ViewModel.CarViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="carAssign",results={
		@Result(name="add",location="/Caraddoredit.jsp"),
		@Result(name="edit",location="/Caraddoredit.jsp"),
		@Result(name="list",location="/Carlist.jsp")})
@Controller
public class CarAssign extends ActionSupport{
	
	private CarViewModel cvm;
	
	 private String carId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "carService")
	private ICarService carService;

	private List list;

	public CarViewModel getCvm() {
		return cvm;
	}

	public void setCvm(CarViewModel cvm) {
		this.cvm = cvm;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}
	
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	public String add(){
		CarViewModel carViewModel=new CarViewModel();
		
		Car car = new Car();
		
		ViewClass vc=new ViewClass();
		 vc.action="carAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 carViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(car);
		
		carViewModel.setInput(viewStringSet.Addset());
		
		cvm = carViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		CarViewModel carViewModel=new CarViewModel();
		
		Car car = carService.edit(Integer.parseInt(carId));
		
		ViewClass vc=new ViewClass();
		 vc.action="carAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 carViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(car);
		
		carViewModel.setInput(viewStringSet.updateset());
		
		cvm = carViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 CarViewModel carViewModel=new CarViewModel();
		
		 list = carService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			carViewModel.setList(viewStringSet.listSet(list));
			carViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"carAssign!add\">增加记录</a>");
			
			cvm = carViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 CarViewModel carViewModel=new CarViewModel();
		 list = carService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			carViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = carViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
