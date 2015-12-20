package dao;

import java.util.List;

import Model.Staffinfo;

public interface IStaffinfoDao {
	public void attachDirty(Staffinfo instance);
	public Staffinfo findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
