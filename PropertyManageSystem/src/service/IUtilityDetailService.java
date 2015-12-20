package service;

import java.util.List;

import Model.UtilityDetail;

public interface IUtilityDetailService {
	public void addoredit(UtilityDetail intent);
	public UtilityDetail edit(int id);
	public List findall();
	public void deletebyid(int id);
}
