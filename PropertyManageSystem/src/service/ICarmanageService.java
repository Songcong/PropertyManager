package service;

import java.util.List;

import Model.Carmanage;;

public interface ICarmanageService {

	public void addoredit(Carmanage intent);
	public Carmanage edit(int id);
	public List findall();
	public void deletebyid(int id);
}
