package service;

import java.util.List;

import Model.Stall;

public interface IStallService {

	public void addoredit(Stall userinfo);
	public Stall edit(int id);
	public List findall();
	public void deletebyid(int id);
}
