package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IOfforestService;
import Model.Offorest;
import dao.IOfforestDao;

import javax.annotation.Resource;

@Service("offorestService")
public class OfforestService  implements IOfforestService{
	
	@Resource(name = "offorestDAO")
	private IOfforestDao offorestDao;
	
	
	
	
	public void addoredit(Offorest intent){
		offorestDao.attachDirty(intent);
	}
	public Offorest edit(int id){
		return offorestDao.findById(id);
	}
	public List findall(){
		
		return	offorestDao.findAll();
	}
	public void deletebyid(int id){
		offorestDao.deletebyid(id);
	}
	
}
