package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IOccupationService;
import Model.Occupation;
import dao.IOccupationDao;

import javax.annotation.Resource;

@Service("occupationService")
public class OccupationService  implements IOccupationService{
	
	@Resource(name = "occupationDAO")
	private IOccupationDao occupationDao;
	
	
	
	
	public void addoredit(Occupation intent){
		occupationDao.attachDirty(intent);
	}
	public Occupation edit(int id){
		return occupationDao.findById(id);
	}
	public List findall(){
		
		return	occupationDao.findAll();
	}
	public void deletebyid(int id){
		occupationDao.deletebyid(id);
	}
	
}
