package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Carmanage;
import service.ICarmanageService;

import javax.annotation.Resource;


@Action (value="carmanageAction",results={
		@Result(name="list",type="redirectAction",location="carmanageAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class CarmanageAction {
	
	
	@Resource(name = "carmanageService")
	private ICarmanageService carmanageService;
	
	private Carmanage carmanage;
	private String carmanageid;
	public Carmanage getCarmanage() {
		return carmanage;
	}
	public void setCarmanage(Carmanage carmanage) {
		this.carmanage = carmanage;
	}
	public String getCarmanageid() {
		return carmanageid;
	}
	public void setCarmanageid(String carmanageid) {
		this.carmanageid = carmanageid;
	}
	
	
	public String add(){
		carmanageService.addoredit(carmanage);
		return "list";
	}
	public String edit(){
		carmanageService.addoredit(carmanage);
		return "list";
	}
	public String delete(){
		carmanageService.deletebyid(Integer.parseInt(carmanageid));
		return "list";
	}
	
	
	
	
}
