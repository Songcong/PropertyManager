package service;

import java.util.List;

import Model.Occupation;

public interface IOccupationService {
	public void addoredit(Occupation intent);
	public Occupation edit(int id);
	public List findall();
	public void deletebyid(int id);
}
