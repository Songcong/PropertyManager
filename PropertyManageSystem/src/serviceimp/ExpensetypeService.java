package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IExpensetypeService;
import dao.IExpensetypeDao;
import Model.Expensetype;

import javax.annotation.Resource;;

@Service("expensetypeService")
public class ExpensetypeService implements IExpensetypeService {
	
	@Resource(name = "expensetypeDAO")
	private IExpensetypeDao expensetypeDAO;

	public void addoredit(Expensetype intent){
		expensetypeDAO.attachDirty(intent);
	}
	public Expensetype edit(int id){
		return expensetypeDAO.findById(id);
	}
	public List findall(){
		
		return	expensetypeDAO.findAll();
	}
	public void deletebyid(int id){
		expensetypeDAO.deletebyid(id);
	}
}
