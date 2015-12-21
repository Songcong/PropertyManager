package dao;

import java.util.List;



import Model.Service;

public interface IServiceDao {
	public void attachDirty(Service instance);
	public Service findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
	public List<Service> findByFacilitypro(Object facilitypro);
}
