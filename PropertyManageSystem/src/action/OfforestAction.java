package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Offorest;
import service.IOfforestService;

import javax.annotation.Resource;

@Action (value="offorestAction",results={
		@Result(name="list",type="redirectAction",location="offorestAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class OfforestAction {

	
	@Resource(name = "offorestService")
	private IOfforestService offorestService;
	
	
	private Offorest offorest;
	
	private String afforestId;
	
	
	public Offorest getOfforest() {
		return offorest;
	}
	public void setOfforest(Offorest offorest) {
		this.offorest = offorest;
	}

	
	public String add(){
		offorestService.addoredit(offorest);
		return "list";
	}
	public String edit(){
		offorestService.addoredit(offorest);
		return "list";
	}
	public String delete(){
		offorestService.deletebyid(Integer.parseInt(afforestId));
		return "list";
	}
	public String getAfforestId() {
		return afforestId;
	}
	public void setAfforestId(String afforestId) {
		this.afforestId = afforestId;
	}
}
