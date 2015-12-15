package service;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Service;

import Model.Login;
import Model.Userinfo;


public interface LoginService {
	
	public List<Userinfo> Login(Userinfo userinfo);

}
