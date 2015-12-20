package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.ITrackRecordService;
import Model.TrackRecord;
import dao.ITrackRecordDao;

import javax.annotation.Resource;

@Service("trackRecordService")
public class TrackRecordService  implements ITrackRecordService{
	
	@Resource(name = "trackRecordDAO")
	private ITrackRecordDao trackRecordDao;
	
	
	
	
	public void addoredit(TrackRecord intent){
		trackRecordDao.attachDirty(intent);
	}
	public TrackRecord edit(int id){
		return trackRecordDao.findById(id);
	}
	public List findall(){
		
		return	trackRecordDao.findAll();
	}
	public void deletebyid(int id){
		trackRecordDao.deletebyid(id);
	}
	
}
