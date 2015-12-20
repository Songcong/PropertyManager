package service;

import java.util.List;

import Model.HouseManage;

public interface IHouseManageService {
	public void addoredit(HouseManage intent);
	public HouseManage edit(int id);
	public List findall();
	public void deletebyid(int id);
}
