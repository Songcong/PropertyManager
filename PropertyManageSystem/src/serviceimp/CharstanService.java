package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.ICharstanService;
import dao.ICharstanDao;
import Model.Charstan;
import javax.annotation.Resource;

@Service("charstanService")
public class CharstanService implements ICharstanService {
	
	@Resource(name = "charstanDAO")
	private ICharstanDao  charStanDAO;
	
	public void addoredit(Charstan intent){
		charStanDAO.attachDirty(intent);
	}
	public Charstan edit(int id){
		return charStanDAO.findById(id);
	}
	public List findall(){
		
		return	charStanDAO.findAll();
	}
	public void deletebyid(int id){
		charStanDAO.deletebyid(id);
	}
}
