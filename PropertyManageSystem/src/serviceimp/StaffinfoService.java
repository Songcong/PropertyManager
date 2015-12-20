package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IStaffinfoService;
import Model.Staffinfo;
import dao.IStaffinfoDao;

import javax.annotation.Resource;

@Service("staffinfoService")
public class StaffinfoService  implements IStaffinfoService{
	
	@Resource(name = "staffinfoDAO")
	private IStaffinfoDao staffinfoDao;
	
	
	
	
	public void addoredit(Staffinfo intent){
		staffinfoDao.attachDirty(intent);
	}
	public Staffinfo edit(int id){
		return staffinfoDao.findById(id);
	}
	public List findall(){
		
		return	staffinfoDao.findAll();
	}
	public void deletebyid(int id){
		staffinfoDao.deletebyid(id);
	}
	
}
