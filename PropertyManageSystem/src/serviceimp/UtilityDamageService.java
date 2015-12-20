package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IUtilityDamageService;
import Model.UtilityDamage;
import dao.IUtilityDamageDao;

import javax.annotation.Resource;

@Service("utilityDamageService")
public class UtilityDamageService  implements IUtilityDamageService{
	
	@Resource(name = "utilityDamageDAO")
	private IUtilityDamageDao utilityDamageDao;
	
	
	
	
	public void addoredit(UtilityDamage intent){
		utilityDamageDao.attachDirty(intent);
	}
	public UtilityDamage edit(int id){
		return utilityDamageDao.findById(id);
	}
	public List findall(){
		
		return	utilityDamageDao.findAll();
	}
	public void deletebyid(int id){
		utilityDamageDao.deletebyid(id);
	}
	
}
