package com.example.SpringBootCrudApi.Dao;

import java.util.List;

import com.example.SpringBootCrudApi.Modal.Employee;

public interface IEmployeeDao {
	//to retrive list of all employee
	List<Employee> get();
	
	//to retrive one employee using id
	Employee get(int id);
	
	//to save Employee
	void save(Employee employee);
	
	//to delete one employee using id
	String delete(int id);

}
