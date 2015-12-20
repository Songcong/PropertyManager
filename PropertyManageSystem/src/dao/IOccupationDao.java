package dao;

import java.util.List;

import Model.Occupation;

public interface IOccupationDao {
	public void attachDirty(Occupation instance);
	public Occupation findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
