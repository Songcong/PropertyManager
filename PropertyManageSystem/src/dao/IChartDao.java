package dao;

import java.util.List;

import Model.Chart;

public interface IChartDao {

	public void attachDirty(Chart instance);
	public Chart findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
}
