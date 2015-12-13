package Utilx;

import java.lang.reflect.Field;

public class ViewStringSet {
	private Object datamodel;
	private Object viewmodel;
	
	
	public ViewStringSet(Object datamodel,Object viewmodel){
		this.datamodel = datamodel;
		this.viewmodel = viewmodel;
	}
	
	public Object getDatamodel() {
		return datamodel;
	}

	public void setDatamodel(Object datamodel) {
		this.datamodel = datamodel;
		
	}
	
	public Object Addset() throws IllegalArgumentException, IllegalAccessException{
		
		Field[] datafields = datamodel.getClass().getDeclaredFields();
		Field[] viewfields = viewmodel.getClass().getDeclaredFields();
		
		for (Field vfield : viewfields) {
			for (Field dfield : datafields) {
				vfield.setAccessible(true);
				dfield.setAccessible(true);
				if(dfield!=null&&vfield!=null&&vfield.getName().equals(dfield.getName())){
					String fieldname=dfield.getName();
					String label = (String) vfield.get(viewmodel);
					vfield.set(viewmodel,"<label for='"+fieldname+"'>"+label+"</>"
							+ "<input type='text' name='"+fieldname
							+"' value='' />\n");
				}
			}
		}
		
		return viewmodel;
	}
	
public Object updateset() throws IllegalArgumentException, IllegalAccessException{
		
		Field[] datafields = datamodel.getClass().getDeclaredFields();
		Field[] viewfields = viewmodel.getClass().getDeclaredFields();
		
		for (Field vfield : viewfields) {
			for (Field dfield : datafields) {
				vfield.setAccessible(true);
				dfield.setAccessible(true);
				if(dfield!=null&&vfield!=null&&vfield.getName().equals(dfield.getName())){
					String fieldname=dfield.getName();
					String fieldvalue=(String) dfield.get(datamodel);
					String label = (String) vfield.get(viewmodel);
					vfield.set(viewmodel,"<label for='"+fieldname+"'>"+label+"</>"
							+ "<input type='text' name='"+fieldname
							+"' value='"+fieldvalue+"' />\n");
				}
			}
		}
		
		return viewmodel;
	}
	
}
