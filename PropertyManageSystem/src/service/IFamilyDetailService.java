package service;

import java.util.List;

import Model.FamilyDetail;

public interface IFamilyDetailService {
	public void addoredit(FamilyDetail intent);
	public FamilyDetail edit(int id);
	public List findall();
	public void deletebyid(int id);
}
