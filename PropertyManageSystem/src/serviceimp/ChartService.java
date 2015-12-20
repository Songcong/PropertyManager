package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IChartService;
import Model.Chart;
import dao.IChartDao;

import javax.annotation.Resource;

@Service("chartService")
public class ChartService  implements IChartService{
	
	@Resource(name = "chartDAO")
	private IChartDao chartDao;
	
	
	
	
	public void addoredit(Chart intent){
		chartDao.attachDirty(intent);
	}
	public Chart edit(int id){
		return chartDao.findById(id);
	}
	public List findall(){
		
		return	chartDao.findAll();
	}
	public void deletebyid(int id){
		chartDao.deletebyid(id);
	}
	
}
