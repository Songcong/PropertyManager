package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IFitmentService;
import Model.Fitment;
import dao.IFitmentDao;

import javax.annotation.Resource;

@Service("fitmentService")
public class FitmentService  implements IFitmentService{
	
	@Resource(name = "fitmentDAO")
	private IFitmentDao fitmentDao;
	
	
	
	
	public void addoredit(Fitment intent){
		fitmentDao.attachDirty(intent);
	}
	public Fitment edit(int id){
		return fitmentDao.findById(id);
	}
	public List findall(){
		
		return	fitmentDao.findAll();
	}
	public void deletebyid(int id){
		fitmentDao.deletebyid(id);
	}
	
}
