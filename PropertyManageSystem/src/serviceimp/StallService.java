package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IStallService;
import Model.Stall;
import dao.IStallDao;

import javax.annotation.Resource;

@Service("stallService")
public class StallService  implements IStallService{
	
	@Resource(name = "stallDAO")
	private IStallDao stallDao;
	
	
	
	
	public void addoredit(Stall intent){
		stallDao.attachDirty(intent);
	}
	public Stall edit(int id){
		return stallDao.findById(id);
	}
	public List findall(){
		
		return	stallDao.findAll();
	}
	public void deletebyid(int id){
		stallDao.deletebyid(id);
	}
	
}
