package service;

import java.util.List;

import Model.ForeignManage;

public interface IForeignManageService {
	public void addoredit(ForeignManage intent);
	public ForeignManage edit(int id);
	public List findall();
	public void deletebyid(int id);
}
