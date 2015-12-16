package dao;

import java.util.List;

import Model.Userinfo;

public interface IUserinfoDao {

	public List<Userinfo> Login(Userinfo userinfo);
	public void attachDirty(Userinfo instance);
	public Userinfo findById(java.lang.Integer id);
	public List<Userinfo> findAll();
	public void deletebyid(int id);
}
