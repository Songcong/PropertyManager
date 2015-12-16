package Utilx;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLstringset {
	public Object model;
	
	private String sqltable="";
	private String sqlv="";
	
	
	//String sqldelete="delete from {0}";
	//String sqlselect="select * from {0} ";

	
	public Object getModel() {
		return model;
	}


	public void setModel(Object model) {
		this.model = model;
	}
	
	public SQLstringset(Object model) throws IllegalArgumentException, IllegalAccessException{
		this.model = model;
		this.init();
		
	}

	public void init() throws IllegalArgumentException, IllegalAccessException{
		sqltable=model.getClass().getSimpleName();
		
		Field[] fields = model.getClass().getDeclaredFields();
		
		
		for (int i=0;i<fields.length;i++) {

			fields[i].setAccessible(true);
			if(i==fields.length-1)
			{
				sqlv += fields[i].getName()+"='"+fields[i].get(model)+"'";
				//System.out.println(sqlv);
			}
			else {
				sqlv += fields[i].getName()+"='"+fields[i].get(model)+"',";
				//System.out.println(sqlv);
			}
		}
		
	}
	public String sqlinsert(){
		String	sqlinsert="insert into "+sqltable+" set "+sqlv;
		
		return sqlinsert;	
	}
	public String sqlupdate(String where){
		if(where!=null&&"".equals(where))
		{
			where = "";			
		}
		else {
			where = " where "+ where ;
		}
		//System.out.println(sqlv);
		String	sqlupdate="update "+sqltable+" set "+sqlv+" "+where; 
		
		return sqlupdate;
	}
	
	

}
