package serviceimp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import Model.Login;
import dao.LoginDao;
import service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

@Service("loginService")
public class LoginServiceImp implements LoginService {
	@Resource(name="logindao")
	private LoginDao logindao;

	public List<Login> Login(Login login) {
		return logindao.Login(login);
	}

	public void setLogindao(LoginDao logindao) {
		this.logindao = logindao;
	}

}
