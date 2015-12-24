package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.ICarService;
import Model.Car;
import dao.ICarDao;

import javax.annotation.Resource;

@Service("carService")
public class CarService  implements ICarService{
	
	@Resource(name = "carDAO")
	private ICarDao carDao;
	
	
	
	
	public void addoredit(Car intent){
		carDao.attachDirty(intent);
	}
	public Car edit(int id){
		return carDao.findById(id);
	}
	public List findall(){
		
		return	carDao.findAll();
	}
	public void deletebyid(int id){
		carDao.deletebyid(id);
	}
	public List likeByProperty(String propertyName,String value){
	 List list	= carDao.likeByProperty(propertyName, value);
		return list;
	}
}
