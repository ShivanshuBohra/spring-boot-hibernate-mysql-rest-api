package com.example.SpringBootCrudApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootCrudApi.Dao.EmployeeDao;
import com.example.SpringBootCrudApi.Modal.Employee;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	@Override
	public List<Employee> get() {
		return employeeDao.get();
	}

	@Transactional
	@Override
	public Employee get(int id) {
		return employeeDao.get(id);
	}
    
	@Transactional
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}
  @Transactional
	@Override
	public String delete(int id) {
		return employeeDao.delete(id);
		
	}

}
