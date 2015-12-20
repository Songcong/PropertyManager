package dao;

import java.util.List;

import Model.PublicUtilityManage;

public interface IPublicUtilityManageDao {
	public void attachDirty(PublicUtilityManage instance);
	public PublicUtilityManage findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
