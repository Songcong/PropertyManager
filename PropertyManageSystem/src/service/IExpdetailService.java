package service;

import java.util.List;

import Model.Expdetail;

public interface IExpdetailService {

	public void addoredit(Expdetail intent);
	public Expdetail edit(int id);
	public List findall();
	public void deletebyid(int id);
}
