package serviceimp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.IRegisterService;
import Model.Userinfo;
import dao.IUserinfoDao;

@Service("registerService")
public class RegisterService implements IRegisterService {
	
	@Resource(name="userinfoDAO")
	private IUserinfoDao userinfoDAO;
	
	public void setUserinfoDAO(IUserinfoDao userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}

	public void register(Userinfo userinfo){
		userinfoDAO.attachDirty(userinfo);
	}
	public Userinfo edit(int id){
		return userinfoDAO.findById(id);
	}
	
}
