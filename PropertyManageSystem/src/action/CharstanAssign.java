package action;

import java.beans.IntrospectionException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.ICharstanService;
import Model.Charstan;
import Utilx.ViewStringSet;
import ViewModel.CharstanViewModel;
import ViewModel.ViewClass;


@Action (value="charstanAssign",results={
		@Result(name="add",location="/Charstanaddoredit.jsp"),
		@Result(name="edit",location="/Charstanaddoredit.jsp"),
		@Result(name="list",location="/Charstanlist.jsp")})
@Controller
public class CharstanAssign extends ActionSupport {
	
	private CharstanViewModel cvm;
	
	 private String stanId;
	 
	 @Resource(name = "charstanService")
	private ICharstanService charstanService;

	private List list;

	public CharstanViewModel getCvm() {
		return cvm;
	}

	public void setCvm(CharstanViewModel cvm) {
		this.cvm = cvm;
	}


	
	
	public String add(){
		CharstanViewModel charstanViewModel=new CharstanViewModel();
		
		Charstan charstan = new Charstan();
		
		ViewClass vc=new ViewClass();
		 vc.action="charstanAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加收费标准信息</h2></div>";
		 charstanViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(charstan);
		
		charstanViewModel.setInput(viewStringSet.Addset());
		
		cvm = charstanViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		CharstanViewModel charstanViewModel=new CharstanViewModel();
		
		Charstan charstan = charstanService.edit(Integer.parseInt(stanId));
		
		ViewClass vc=new ViewClass();
		 vc.action="charstanAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑收费标准信息</h2></div>";
		 charstanViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(charstan);
		
		charstanViewModel.setInput(viewStringSet.updateset());
		
		cvm = charstanViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 CharstanViewModel charstanViewModel=new CharstanViewModel();
		
		 list = charstanService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			charstanViewModel.setList(viewStringSet.listSet(list));
			
			cvm = charstanViewModel;
			
			
			return "list";
	}

	public String getStanId() {
		return stanId;
	}

	public void setStanId(String stanId) {
		this.stanId = stanId;
	}
}
