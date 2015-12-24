package dao;

import java.util.List;

import Model.Car;

public interface ICarDao {
	public void attachDirty(Car instance);
	public Car findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
	public List findByProperty(String propertyName, Object value);
	public List likeByProperty(String propertyName, Object value);
}
