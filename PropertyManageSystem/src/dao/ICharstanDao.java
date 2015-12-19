package dao;

import java.util.List;

import Model.Charstan;
import Model.Expensetype;

public interface ICharstanDao {
	public void attachDirty(Charstan instance);
	public Charstan findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
