package dao;

import java.util.List;

import Model.Jobtype;

public interface IJobtypeDao {
	public void attachDirty(Jobtype instance);
	public Jobtype findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
