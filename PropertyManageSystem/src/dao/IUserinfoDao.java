package dao;

import java.util.List;

import Model.Userinfo;

public interface IUserinfoDao {

	public List<Userinfo> Login(Userinfo userinfo);
}
