package dao;

import java.util.List;

import Model.UtilityDamage;

public interface IUtilityDamageDao {
	public void attachDirty(UtilityDamage instance);
	public UtilityDamage findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
