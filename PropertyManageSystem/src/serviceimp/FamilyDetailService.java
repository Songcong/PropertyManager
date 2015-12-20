package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IFamilyDetailService;
import Model.FamilyDetail;
import dao.IFamilyDetailDao;

import javax.annotation.Resource;

@Service("familyDetailService")
public class FamilyDetailService  implements IFamilyDetailService{
	
	@Resource(name = "familyDetailDAO")
	private IFamilyDetailDao familyDetailDao;
	
	
	
	
	public void addoredit(FamilyDetail intent){
		familyDetailDao.attachDirty(intent);
	}
	public FamilyDetail edit(int id){
		return familyDetailDao.findById(id);
	}
	public List findall(){
		
		return	familyDetailDao.findAll();
	}
	public void deletebyid(int id){
		familyDetailDao.deletebyid(id);
	}
	
}
