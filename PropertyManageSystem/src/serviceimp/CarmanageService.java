package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import Model.Carmanage;
import dao.ICarDao;
import dao.ICarmanageDao;
import service.ICarmanageService;

import javax.annotation.Resource;

@Service("carmanageService")
public class CarmanageService  implements ICarmanageService{
	
	
	@Resource(name = "carmanageDAO")
	private ICarmanageDao carmanageDAO;
	
	
	public void addoredit(Carmanage intent){
		carmanageDAO.attachDirty(intent);
	}
	public Carmanage edit(int id){
		return carmanageDAO.findById(id);
	}
	public List findall(){
		
		return	carmanageDAO.findAll();
	}
	public void deletebyid(int id){
		carmanageDAO.deletebyid(id);
	}
}
