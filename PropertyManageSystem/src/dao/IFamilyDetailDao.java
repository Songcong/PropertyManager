package dao;

import java.util.List;

import Model.FamilyDetail;

public interface IFamilyDetailDao {
	public void attachDirty(FamilyDetail instance);
	public FamilyDetail findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
