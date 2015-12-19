package dao;

import java.util.List;

import Model.Expensetype;

public interface IExpensetypeDao {
	public void attachDirty(Expensetype instance);
	public Expensetype findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
