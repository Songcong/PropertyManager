package Utilx;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class ViewStringSet {
	private Object datamodel;
	private Object viewmodel;

	public ViewStringSet(Object datamodel, Object viewmodel) {
		this.datamodel = datamodel;
		this.viewmodel = viewmodel;
	}

	public Object getDatamodel() {
		return datamodel;
	}

	public void setDatamodel(Object datamodel) {
		this.datamodel = datamodel;

	}

	public Object Addset() throws IllegalArgumentException,
			IllegalAccessException, NoSuchFieldException, SecurityException {

		String table = datamodel.getClass().getSimpleName();
		table = table.substring(0, 1).toLowerCase()
				+ table.substring(1, table.length());
		Field[] datafields = datamodel.getClass().getDeclaredFields();
//		Field field = viewmodel.getClass().getField("datamodel");
//		field.setAccessible(true);
//		Object object = field.get(viewmodel);
//		Field[] viewfields = object.getClass().getDeclaredFields();
		Field[] viewfields = viewmodel.getClass().getDeclaredFields();
		for (Field vfield : viewfields) {
			for (Field dfield : datafields) {
				vfield.setAccessible(true);
				dfield.setAccessible(true);
				if (dfield != null && vfield != null
						&& vfield.getName().equals(dfield.getName())) {
					String fieldname = dfield.getName();
					String label = (String) vfield.get(viewmodel);
					vfield.set(viewmodel, "<label for='" + fieldname + "'>"
							+ label + "</label>" + "<input type='text' name='"
							+ table + "." + fieldname + "' id='"+fieldname+"' value='' />\n");

				}
			}
		}

		return viewmodel;
	}

	public Object updateset() throws IllegalArgumentException,
			IllegalAccessException, SecurityException, NoSuchFieldException {

		Field[] datafields = datamodel.getClass().getDeclaredFields();
		Field[] viewfields = viewmodel.getClass().getDeclaredFields();

		for (Field vfield : viewfields) {
			for (Field dfield : datafields) {
				vfield.setAccessible(true);
				dfield.setAccessible(true);
				if (dfield != null && vfield != null
						&& vfield.getName().equals(dfield.getName())) {
					String fieldname = dfield.getName();
					String fieldvalue = (String) dfield.get(datamodel);
					String label = (String) vfield.get(viewmodel);
					vfield.set(viewmodel, "<label for='" + fieldname + "'>"
							+ label + "</label>" + "<input type='text' name='"
							+ fieldname + "' id='" + fieldname + "' value='"
							+ fieldvalue + "' />\n");
				}
			}
		}

		return viewmodel;
	}

	public String listSet(List<Object> list) throws IllegalArgumentException,
			IllegalAccessException {

		String ths = "";
		String trs = "";
		for (Object object : list) {
			String th = "";
			String td = "";
			Field[] datafields = object.getClass().getDeclaredFields();
			String id = "";
			String idvalue="";
			for (Field dfield : datafields) {
				
				dfield.setAccessible(true);
				
				
				String fieldname = dfield.getName();
				String fieldvalue =  dfield.get(object).toString();
				
				
				PropertyDescriptor pd = new PropertyDescriptor(dfield.getName(), clazz);  
				Method getMethod = pd.getReadMethod();
				get

				for (Annotation annotation : annotations) {
					if("Id".equalsIgnoreCase(annotation.getClass().getName())){
						id=fieldname;
						idvalue=fieldvalue;
					}
				}
				td += "<td class='" + fieldname + "'>" + fieldvalue + "</td>";

				th += "<th>" + fieldname + "</th>";

			}

			td = "<tr>" + td + "<td><a class='edit' id=''></a></td><td><a class='delete' id=''></a></td></tr>";
			th = "<tr>" + th + "</tr>";

			trs += td;
			ths = th;
		}

		String lists = ths + trs;

		

		return lists;
	}

}
