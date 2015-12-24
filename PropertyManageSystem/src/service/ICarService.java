package service;

import java.util.List;

import Model.Car;

public interface ICarService {
	public void addoredit(Car intent);
	public Car edit(int id);
	public List findall();
	public void deletebyid(int id);
	public List likeByProperty(String propertyName,String value);
}
