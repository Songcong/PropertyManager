package service;

import java.util.List;

import Model.Jobtype;

public interface IJobtypeService {
	public void addoredit(Jobtype intent);
	public Jobtype edit(int id);
	public List findall();
	public void deletebyid(int id);
}
