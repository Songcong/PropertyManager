package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IExpdetailService;
import dao.IExpdetailDao;
import Model.Expdetail;

import javax.annotation.Resource;;

@Service("expdetailService")
public class ExpdetailService implements IExpdetailService {
	
	@Resource(name = "expdetailDAO")
	private IExpdetailDao expdetailDAO;

	public void addoredit(Expdetail intent){
		expdetailDAO.attachDirty(intent);
	}
	public Expdetail edit(int id){
		return expdetailDAO.findById(id);
	}
	public List findall(){
		
		return	expdetailDAO.findAll();
	}
	public void deletebyid(int id){
		expdetailDAO.deletebyid(id);
	}
}
