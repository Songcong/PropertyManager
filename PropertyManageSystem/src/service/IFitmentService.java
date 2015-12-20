package service;

import java.util.List;

import Model.Fitment;

public interface IFitmentService {
	public void addoredit(Fitment intent);
	public Fitment edit(int id);
	public List findall();
	public void deletebyid(int id);
}
