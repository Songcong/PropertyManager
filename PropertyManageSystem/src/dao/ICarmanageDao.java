package dao;

import java.util.List;

import Model.Carmanage;

public interface ICarmanageDao {
	public void attachDirty(Carmanage instance);
	public Carmanage findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
