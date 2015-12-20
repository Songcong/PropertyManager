package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IUtilityDetailService;
import Model.UtilityDetail;
import dao.IUtilityDetailDao;

import javax.annotation.Resource;

@Service("utilityDetailService")
public class UtilityDetailService  implements IUtilityDetailService{
	
	@Resource(name = "utilityDetailDAO")
	private IUtilityDetailDao utilityDetailDao;
	
	
	
	
	public void addoredit(UtilityDetail intent){
		utilityDetailDao.attachDirty(intent);
	}
	public UtilityDetail edit(int id){
		return utilityDetailDao.findById(id);
	}
	public List findall(){
		
		return	utilityDetailDao.findAll();
	}
	public void deletebyid(int id){
		utilityDetailDao.deletebyid(id);
	}
	
}
