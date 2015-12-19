package service;

import java.util.List;

import Model.Charstan;

public interface ICharstanService {

	public void addoredit(Charstan intent);
	public Charstan edit(int id);
	public List findall();
	public void deletebyid(int id);
}
