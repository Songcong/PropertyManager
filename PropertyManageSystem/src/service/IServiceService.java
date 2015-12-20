package service;

import java.util.List;

import Model.Service;

public interface IServiceService {
	public void addoredit(Service intent);
	public Service edit(int id);
	public List findall();
	public void deletebyid(int id);
}
