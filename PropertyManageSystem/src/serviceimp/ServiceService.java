package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IServiceService;
import dao.IServiceDao;

import Model.*;
import javax.annotation.Resource;


@Service("serviceService")
public class ServiceService  implements IServiceService{
	
	@Resource(name = "serviceDAO")
	private IServiceDao serviceDao;
	
	
	
	
	public void addoredit(Model.Service intent){
		serviceDao.attachDirty(intent);
	}
	public Model.Service edit(int id){
		return serviceDao.findById(id);
	}
	public List findall(){
		
		return	serviceDao.findAll();
	}
	public void deletebyid(int id){
		serviceDao.deletebyid(id);
	}
	
	
}
