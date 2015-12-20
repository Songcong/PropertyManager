package dao;

import java.util.List;

import Model.UtilityDetail;

public interface IUtilityDetailDao {
	public void attachDirty(UtilityDetail instance);
	public UtilityDetail findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
