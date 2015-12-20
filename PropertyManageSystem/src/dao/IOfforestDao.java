package dao;

import java.util.List;

import Model.Offorest;

public interface IOfforestDao {
	public void attachDirty(Offorest instance);
	public Offorest findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
