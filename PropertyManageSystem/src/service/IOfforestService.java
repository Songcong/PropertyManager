package service;

import java.util.List;

import Model.Offorest;

public interface IOfforestService {
	public void addoredit(Offorest intent);
	public Offorest edit(int id);
	public List findall();
	public void deletebyid(int id);
}
