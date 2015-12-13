package Utilx;

import Model.Login;
import ViewModel.LoginViewModel;

public class Test {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		LoginViewModel loginViewModel = new LoginViewModel();
		Login login = new Login();
		
		login.setPassword("sajkdljal");
		login.setUsername("sadasd");
		ViewStringSet viewStringSet = new ViewStringSet(login, loginViewModel);
		
		loginViewModel.setHeader("<header>");
		loginViewModel.setFooter("<footer>");
		loginViewModel.setUsername("用户名：");
		loginViewModel.setPassword("密码：");
		
		//loginViewModel=(LoginViewModel) viewStringSet.Addset();
		
		loginViewModel=(LoginViewModel) viewStringSet.updateset();
		System.out.println(loginViewModel.getUsername()+loginViewModel.getPassword());
		
		
	}
}
