package Utilx;

import java.util.ArrayList;
import java.util.List;

import Model.Login;
import Model.Userinfo;
import ViewModel.LoginViewModel;

public class Test {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {
		
		LoginViewModel loginViewModel = new LoginViewModel();
		Userinfo userinfo = new Userinfo();
		
		userinfo.setPassword("sajkdljal");
		userinfo.setUsername("sadasd");
		userinfo.setUserid(1);
		userinfo.setAddress("sad");
		ViewStringSet viewStringSet = new ViewStringSet(userinfo, loginViewModel);
		List<Object> list=new ArrayList<Object>();
		list.add(userinfo);
//		loginViewModel.viewclass.setHeader("sadsad");
//		loginViewModel=(LoginViewModel) viewStringSet.Addset();
		String s=viewStringSet.listSet(list);
//		loginViewModel=(LoginViewModel) viewStringSet.updateset();
		//System.out.println(loginViewModel.getUsername()+loginViewModel.getPassword()+loginViewModel.viewclass.getHeader());
		System.out.println(s);
		
	}
}
