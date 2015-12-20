package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IHouseOwnerManageService;
import Model.HouseOwnerManage;
import dao.IHouseOwnerManageDao;

import javax.annotation.Resource;

@Service("houseOwnerManageService")
public class HouseOwnerManageService  implements IHouseOwnerManageService{
	
	@Resource(name = "houseOwnerManageDAO")
	private IHouseOwnerManageDao houseOwnerManageDao;
	
	
	
	
	public void addoredit(HouseOwnerManage intent){
		houseOwnerManageDao.attachDirty(intent);
	}
	public HouseOwnerManage edit(int id){
		return houseOwnerManageDao.findById(id);
	}
	public List findall(){
		
		return	houseOwnerManageDao.findAll();
	}
	public void deletebyid(int id){
		houseOwnerManageDao.deletebyid(id);
	}
	
}
