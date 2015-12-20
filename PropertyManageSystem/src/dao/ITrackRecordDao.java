package dao;

import java.util.List;

import Model.TrackRecord;

public interface ITrackRecordDao {
	public void attachDirty(TrackRecord instance);
	public TrackRecord findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
