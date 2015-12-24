package action;

import java.beans.IntrospectionException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.ICarService;
import service.ICarmanageService;
import Model.Carmanage;
import Utilx.ViewStringSet;
import ViewModel.CarmanageViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;



	@Action (value="carmanageAssign",results={
			@Result(name="add",location="/Carmanageaddoredit.jsp"),
			@Result(name="edit",location="/Carmanageaddoredit.jsp"),
			@Result(name="list",location="/Carmanagelist.jsp")})
	@Controller
	public class CarmanageAssign extends ActionSupport{
		
		private CarmanageViewModel cvm;
		
		 private String carmanageid;
		 
		 @Resource(name = "carmanageService")
		private ICarmanageService carmanageService;

		private List list;

		public CarmanageViewModel getCvm() {
			return cvm;
		}

		public void setCvm(CarmanageViewModel cvm) {
			this.cvm = cvm;
		}

		public String getCarmanageid() {
			return carmanageid;
		}

		public void setCarmanageid(String carmanageId) {
			this.carmanageid = carmanageId;
		}

		
		
		public String add(){
			CarmanageViewModel carmanageViewModel=new CarmanageViewModel();
			
			Carmanage carmanage = new Carmanage();
			
			ViewClass vc=new ViewClass();
			 vc.action="carmanageAction!add";
			 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆管理信息</h2></div>";
			 carmanageViewModel.viewClass=vc;
			
			ViewStringSet viewStringSet = new ViewStringSet(carmanage);
			
			carmanageViewModel.setInput(viewStringSet.Addset());
			
			cvm = carmanageViewModel;
			
			
			return "add";
			
		}
		
		public String edit(){
			
			CarmanageViewModel carmanageViewModel=new CarmanageViewModel();
			
			Carmanage carmanagemanage = carmanageService.edit(Integer.parseInt(carmanageid));
			
			ViewClass vc=new ViewClass();
			 vc.action="carmanageAction!edit";
			 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆管理信息</h2></div>";
			 carmanageViewModel.viewClass=vc;
			
			ViewStringSet viewStringSet = new ViewStringSet(carmanagemanage);
			
			carmanageViewModel.setInput(viewStringSet.updateset());
			
			cvm = carmanageViewModel;
			
			
			return "edit";
			
		}
		
		public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
			
			CarmanageViewModel carmanageViewModel=new CarmanageViewModel();
			
			 list = carmanageService.findall();
			 
			 ViewStringSet viewStringSet = new ViewStringSet();
				
			 carmanageViewModel.setList(viewStringSet.listSet(list));
				
				cvm = carmanageViewModel;
				
				
				return "list";
		}
}

