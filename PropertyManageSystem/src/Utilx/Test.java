package Utilx;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;

import Model.Car;
import Model.Login;
import Model.Userinfo;
import ViewModel.LoginViewModel;

public class Test {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException, IntrospectionException {
		
		LoginViewModel loginViewModel = new LoginViewModel();
//		Userinfo userinfo = new Userinfo();
//		
//		userinfo.setPassword("sajkdljal");
//		userinfo.setUsername("sadasd");
//		userinfo.setUserid(1);
//		userinfo.setAddress("sad");
		
		Car car=new Car();
		ViewStringSet viewStringSet = new ViewStringSet(car);
		List<Object> list=new ArrayList<Object>();
//		list.add(userinfo);
//		loginViewModel.viewclass.setHeader("sadsad");
		String d=viewStringSet.Addset();
//		String s=viewStringSet.listSet(list);
		//String s= viewStringSet.updateset();
		//System.out.println(loginViewModel.getUsername()+loginViewModel.getPassword()+loginViewModel.viewclass.getHeader());
		System.out.println(d);
		
	}
}
