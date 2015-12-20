package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IJobtypeService;
import Model.Jobtype;
import dao.IJobtypeDao;

import javax.annotation.Resource;

@Service("jobtypeService")
public class JobtypeService  implements IJobtypeService{
	
	@Resource(name = "jobtypeDAO")
	private IJobtypeDao jobtypeDao;
	
	
	
	
	public void addoredit(Jobtype intent){
		jobtypeDao.attachDirty(intent);
	}
	public Jobtype edit(int id){
		return jobtypeDao.findById(id);
	}
	public List findall(){
		
		return	jobtypeDao.findAll();
	}
	public void deletebyid(int id){
		jobtypeDao.deletebyid(id);
	}
	
}
