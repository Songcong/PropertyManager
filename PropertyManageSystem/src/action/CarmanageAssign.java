package action;

import java.beans.IntrospectionException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.ICarService;
import Model.Carmanage;
import Utilx.ViewStringSet;
import ViewModel.CarmanageViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

public class CarmanageAssign {

	@Action (value="carmanageAssign",results={
			@Result(name="add",location="/Carmanageaddoredit.jsp"),
			@Result(name="edit",location="/Carmanageaddoredit.jsp"),
			@Result(name="list",location="/Carmanagelist.jsp")})
	@Controller
	public class CarmanageAssign extends ActionSupport{
		
		private CarmanageViewModel cvm;
		
		 private String carmanageId;
		 
		 @Resource(name = "carmanageService")
		private ICarmanageService carmanageService;

		private List list;

		public CarmanageViewModel getCvm() {
			return cvm;
		}

		public void setCvm(CarmanageViewModel cvm) {
			this.cvm = cvm;
		}

		public String getCarmanageId() {
			return carId;
		}

		public void setCarmanageId(String carId) {
			this.carId = carId;
		}

		
		
		public String add(){
			CarmanageViewModel carViewModel=new CarmanageViewModel();
			
			Carmanage car = new Carmanage();
			
			ViewClass vc=new ViewClass();
			 vc.action="CarmanageAction!add";
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
				
				cvm = carViewModel;
				
				
				return "list";
		}
}
