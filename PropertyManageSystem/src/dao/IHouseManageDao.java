package dao;

import java.util.List;

import Model.HouseManage;

public interface IHouseManageDao {
	public void attachDirty(HouseManage instance);
	public HouseManage findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
