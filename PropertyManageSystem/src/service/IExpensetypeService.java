package service;

import java.util.List;

import Model.Expensetype;

public interface IExpensetypeService {

	public void addoredit(Expensetype userinfo);
	public Expensetype edit(int id);
	public List findall();
	public void deletebyid(int id);
}
