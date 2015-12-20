package dao;

import java.util.List;

import Model.HouseOwnerManage;

public interface IHouseOwnerManageDao {
	public void attachDirty(HouseOwnerManage instance);
	public HouseOwnerManage findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
