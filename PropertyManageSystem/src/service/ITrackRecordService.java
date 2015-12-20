package service;

import java.util.List;

import Model.TrackRecord;

public interface ITrackRecordService {
	public void addoredit(TrackRecord intent);
	public TrackRecord edit(int id);
	public List findall();
	public void deletebyid(int id);
}
