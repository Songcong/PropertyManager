package Utilx;

import Model.Login;
import Model.Userinfo;
import ViewModel.LoginViewModel;

public class Test {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		LoginViewModel loginViewModel = new LoginViewModel();
		Userinfo userinfo = new Userinfo();
		
		userinfo.setPassword("sajkdljal");
		userinfo.setUsername("sadasd");
		ViewStringSet viewStringSet = new ViewStringSet(userinfo, loginViewModel);
		
		loginViewModel.setHeader("<header>");
		loginViewModel.setFooter("<footer>");
		loginViewModel.setUsername("用户名：");
		loginViewModel.setPassword("密码：");
		
		loginViewModel=(LoginViewModel) viewStringSet.Addset();
		
		//loginViewModel=(LoginViewModel) viewStringSet.updateset();
		System.out.println(loginViewModel.getUsername()+loginViewModel.getPassword());
		
		
	}
}
