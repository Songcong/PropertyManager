package service;

import java.util.List;

import Model.HouseOwnerManage;

public interface IHouseOwnerManageService {
	public void addoredit(HouseOwnerManage intent);
	public HouseOwnerManage edit(int id);
	public List findall();
	public void deletebyid(int id);
}
