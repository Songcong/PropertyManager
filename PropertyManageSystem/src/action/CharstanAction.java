package action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.ICharstanService;
import Model.Charstan;


@Action (value="charstanAction",results={
		@Result(name="list",type="redirectAction",location="charstanAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class CharstanAction {

	@Resource(name = "charstanService")
	private ICharstanService charstanService;
	
	
	private Charstan charstan;
	
	private String stanId;
	
	
	public Charstan getCharstan() {
		return charstan;
	}
	public void setCharstan(Charstan charstan) {
		this.charstan = charstan;
	}

	public String add(){
		charstanService.addoredit(charstan);
		return "list";
	}
	public String edit(){
		charstanService.addoredit(charstan);
		return "list";
	}
	public String delete(){
		charstanService.deletebyid(Integer.parseInt(stanId));
		return "list";
	}
	public String getStanId() {
		return stanId;
	}
	public void setStanId(String stanId) {
		this.stanId = stanId;
	}
}
