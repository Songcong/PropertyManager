package service;

import java.util.List;

import Model.Chart;

public interface IChartService {
	public void addoredit(Chart intent);
	public Chart edit(int id);
	public List findall();
	public void deletebyid(int id);
}
