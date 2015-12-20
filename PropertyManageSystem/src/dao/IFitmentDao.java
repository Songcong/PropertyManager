package dao;

import java.util.List;

import Model.Fitment;

public interface IFitmentDao {
	public void attachDirty(Fitment instance);
	public Fitment findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
	
}
