package service;

import java.util.List;

import Model.UtilityDamage;

public interface IUtilityDamageService {
	public void addoredit(UtilityDamage intent);
	public UtilityDamage edit(int id);
	public List findall();
	public void deletebyid(int id);
}
