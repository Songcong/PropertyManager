package dao;

import java.util.List;

import Model.Stall;



public interface IStallDao {
	public void attachDirty(Stall instance);
	public Stall findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
