package com.example.SpringBootCrudApi.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootCrudApi.Modal.Employee;

@Service
public class EmployeeDao implements IEmployeeDao{
   // @transaction use : if any exception occur then the previous operation is rollback
	//eg if we add a employee with int instead of String then record will not be upated in Mysql if error occours, without @transactional record will be updated
	
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public List<Employee> get() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> querry = currentSession.createQuery("from Employee", Employee.class);
		  List<Employee> listOfEmployee =  querry.getResultList();
		  return listOfEmployee;
	}
   
	@Transactional
	@Override
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		return employeeObj;
		
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		// use.save if you only want to save .. saveorUpdate will update DB if id already exists in table
		currentSession.saveOrUpdate(employee);
		
	}

	@Transactional
	@Override
	public String delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		currentSession.delete(employeeObj);
		return "Employee has been deleted with id : "+ id;
		
	}

}
