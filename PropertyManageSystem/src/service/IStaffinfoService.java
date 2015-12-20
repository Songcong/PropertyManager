package service;

import java.util.List;

import Model.Staffinfo;

public interface IStaffinfoService {
	public void addoredit(Staffinfo intent);
	public Staffinfo edit(int id);
	public List findall();
	public void deletebyid(int id);
}
