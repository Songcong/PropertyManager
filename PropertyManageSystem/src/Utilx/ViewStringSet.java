package Utilx;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import Anno.Hide;
import Anno.Label;

public class ViewStringSet {
	private Object datamodel;
	private Object viewmodel;

	public ViewStringSet(Object datamodel) {
		this.datamodel = datamodel;
	}

	public ViewStringSet() {
		// TODO Auto-generated constructor stub
	}

	public Object getDatamodel() {
		return datamodel;
	}

	public void setDatamodel(Object datamodel) {
		this.datamodel = datamodel;

	}

//	public Object Addset() throws IllegalArgumentException,
//			IllegalAccessException, NoSuchFieldException, SecurityException {
//
//		String table = datamodel.getClass().getSimpleName();
//		table = table.substring(0, 1).toLowerCase()
//				+ table.substring(1, table.length());
//		Field[] datafields = datamodel.getClass().getDeclaredFields();
//		Field[] viewfields = viewmodel.getClass().getDeclaredFields();
//		for (Field vfield : viewfields) {
//			for (Field dfield : datafields) {
//				vfield.setAccessible(true);
//				dfield.setAccessible(true);
//				if (dfield != null && vfield != null
//						&& vfield.getName().equals(dfield.getName())) {
//					String fieldname = dfield.getName();
//					String label = (String) vfield.get(viewmodel);
//					vfield.set(viewmodel, "<label for='" + fieldname + "'>"
//							+ label + "</label>" + "<input type='text' name='"
//							+ table + "." + fieldname + "' id='"+fieldname+"' value='' /></br>\n");
//
//				}
//			}
//		}
//
//		return viewmodel;
//	}

//	public Object updateset() throws IllegalArgumentException,
//			IllegalAccessException, SecurityException, NoSuchFieldException {
//
//		//反射获得字段集
//		Field[] datafields = datamodel.getClass().getDeclaredFields();
//		Field[] viewfields = viewmodel.getClass().getDeclaredFields();
//		
//		//获得类名
//		String table = datamodel.getClass().getSimpleName();
//		//首字母小写
//		table = table.substring(0, 1).toLowerCase()
//				+ table.substring(1, table.length());
//
//		for (Field vfield : viewfields) {
//			for (Field dfield : datafields) {
//				vfield.setAccessible(true);
//				dfield.setAccessible(true);
//				if (dfield != null && vfield != null
//						&& vfield.getName().equals(dfield.getName())) {
//					//获得字段名
//					String fieldname = dfield.getName();
//					//获得字段值
//					String fieldvalue = String.valueOf(dfield.get(datamodel));
//					
//					String label = (String) vfield.get(viewmodel);
//					//组装成HTML语句并注入到Viewmodel中
//					vfield.set(viewmodel, "<label for='" + fieldname + "'>"
//							+ label + "</label>" + "<input type='text' name='"
//							+table + "."+ fieldname + "' id='" + fieldname + "' value='"
//							+ fieldvalue + "' /></br>\n");
//				}
//			}
//		}
//
//		return viewmodel;
//	}
	
	public String Addset(){
		String str="";
		Field[] datafields = datamodel.getClass().getDeclaredFields();
		//获得类名
		String table = datamodel.getClass().getSimpleName();
		//首字母小写
		table = table.substring(0, 1).toLowerCase()+ table.substring(1, table.length());
	
		for (Field dfield : datafields) {
				String label ="";
				
				//获得字段名
				String fieldname = dfield.getName();
				//获得类型名
				String type = dfield.getType().getSimpleName();
				//类型转换
				type=typeConvert(type);
				
				//获得字段值
				String fieldvalue;
				try {
					dfield.setAccessible(true);
					fieldvalue = String.valueOf(dfield.get(datamodel));
					//获得label
					Annotation[] annotations = dfield.getAnnotations();
					Hide hide = dfield.getAnnotation(Hide.class);
					 Label annotation = dfield.getAnnotation(Label.class);
					 if(annotation!=null){
						 label = annotation.value();
					 }
					 
					 if(hide==null){
					//组装成HTML语句并注入到Viewmodel中
					str+="<label for='" + fieldname + "' class='" + fieldname + "' >"
							+ label + "</label>" + "<input type='"+type+"' name='"
							+table + "."+ fieldname + "' class='" + fieldname +  "' /><br/>";
					 }
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		return str;
	}
	public String updateset(){
		String str="";
		Field[] datafields = datamodel.getClass().getDeclaredFields();
		//获得类名
		String table = datamodel.getClass().getSimpleName();
		//首字母小写
		table = table.substring(0, 1).toLowerCase()+ table.substring(1, table.length());
	
		for (Field dfield : datafields) {
				String label ="";
				//获得字段名
				String fieldname = dfield.getName();
				//获得字段值
				String fieldvalue;
				try {
					dfield.setAccessible(true);
					fieldvalue = String.valueOf(dfield.get(datamodel));
					//获得label
					 Label annotation = dfield.getAnnotation(Label.class);
					 if(annotation!=null){
						 label = annotation.value();
					 }
					//组装成HTML语句并注入到Viewmodel中
					str+="<label for='" + fieldname + "'class='" + fieldname + "'>"
							+ label + "</label>" + "<input type='text' name='"
							+table + "."+ fieldname + "' class='" + fieldname + "' value='"
							+ fieldvalue + "' /></br>\n";
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		return str;
	}
	

	public String listSet(List<Object> list) throws IllegalArgumentException,
			IllegalAccessException, IntrospectionException {

		String ths = "";
		String trs = "";
		String tablename="";
		for (Object object : list) {
			String th = "";
			String td = "";
			
			//获得类名
			tablename=object.getClass().getSimpleName();
			Field[] datafields = object.getClass().getDeclaredFields();
			String id = "";
			String idvalue="";
			for (Field dfield : datafields) {
				String label="";
				//转化为公有属性
				dfield.setAccessible(true);
				
				//获得label
				 Label annotation1 = dfield.getAnnotation(Label.class);
				 if(annotation1!=null){
					 label = annotation1.value();
				 }
				
				String fieldname = dfield.getName();
				String fieldvalue =  String.valueOf(dfield.get(object));
				
				if("null".equalsIgnoreCase(fieldvalue))
				{
					fieldvalue="";
				}
				
				//获得字段对应的get方法
				PropertyDescriptor pd = new PropertyDescriptor(dfield.getName(), object.getClass());  
				Method getMethod = pd.getReadMethod();
				
				//获得Get方法注解
				Annotation[] annotations = getMethod.getDeclaredAnnotations();
				

				for (Annotation annotation : annotations) {
					//判断是不是主键
					if("Id".equalsIgnoreCase(annotation.annotationType().getSimpleName())){
						//获得主键名和值
						id=fieldname;
						idvalue=fieldvalue;
					}
				}
				
				
				//拼接td
				td += "<td class='" + fieldname + "'>" + fieldvalue + "</td>\n";
				//拼接th
				th += "<th class='"+fieldname+"'>" + label + "</th>\n";

			}
			//首字母小写
			String tablenamel=tablename.substring(0,1).toLowerCase()+tablename.substring(1,tablename.length());
			//增加修改和删除
			td = "<tr>" + td + "<td><a class='edit' id='"+id+idvalue+"'"
					+ " href='"+tablenamel+"Assign!edit?"+id+"="+idvalue+"'>修改</a></td>\n"
					+ "<td><a class='delete' id='"+id+idvalue+"'"
					+ " href='"+tablenamel+"Action!delete?"+id+"="+idvalue+"'>删除</a></td></tr>\n";
			th = "<tr>" + th + "<th colspan='2'>操作</th></tr>";
			
			trs += td;
			ths = th;
		}
		
		String lists ="<table class='"+tablename+"'>\n" +ths + trs+"</table>";

		

		return lists;
	}
	
	public String typeConvert(String typename){
		
		switch (typename) {
		case "Integer": return "number";
		case "Timestamp": return "date";
		default: return "text";
		}
	}

}
