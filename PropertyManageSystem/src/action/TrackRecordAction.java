package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.TrackRecord;
import service.ITrackRecordService;

import javax.annotation.Resource;

@Action (value="trackRecordAction",results={
		@Result(name="list",type="redirectAction",location="trackRecordAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class TrackRecordAction {

	
	@Resource(name = "trackRecordService")
	private ITrackRecordService trackRecordService;
	
	
	private TrackRecord trackRecord;
	
	private String trackRecordId;
	
	
	public TrackRecord getTrackRecord() {
		return trackRecord;
	}
	public void setTrackRecord(TrackRecord trackRecord) {
		this.trackRecord = trackRecord;
	}
	public String getTrackRecordId() {
		return trackRecordId;
	}
	public void setTrackRecordId(String trackRecordId) {
		this.trackRecordId = trackRecordId;
	}
	
	
	
	public String add(){
		trackRecordService.addoredit(trackRecord);
		return "list";
	}
	public String edit(){
		trackRecordService.addoredit(trackRecord);
		return "list";
	}
	public String delete(){
		trackRecordService.deletebyid(Integer.parseInt(trackRecordId));
		return "list";
	}
}
