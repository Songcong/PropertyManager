package service;

import Model.Userinfo;

public interface IRegisterService {
	public void register(Userinfo userinfo);
	public Userinfo edit(int id);
}
