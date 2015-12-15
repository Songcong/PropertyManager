package serviceimp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import Model.Login;
import Model.Userinfo;
import dao.LoginDao;
import dao.IUserinfoDao;
import service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;

@Service("loginService")
public class LoginServiceImp implements LoginService {
	@Resource(name="userinfoDAO")
	private IUserinfoDao userinfoDAO;

	public void setUserinfoDAO(IUserinfoDao userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}

	public List<Userinfo> Login(Userinfo userinfo) {
		return userinfoDAO.Login(userinfo);
	}

	

}
