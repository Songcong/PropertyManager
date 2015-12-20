package service;

import java.util.List;

import Model.PublicUtilityManage;

public interface IPublicUtilityManageService {
	public void addoredit(PublicUtilityManage intent);
	public PublicUtilityManage edit(int id);
	public List findall();
	public void deletebyid(int id);
}
