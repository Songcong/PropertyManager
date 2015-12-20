package dao;

import java.util.List;

import Model.ForeignManage;

public interface IForeignManageDao {
	public void attachDirty(ForeignManage instance);
	public ForeignManage findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
