package com.example.SpringBootCrudApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCrudApi.Modal.Employee;
import com.example.SpringBootCrudApi.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> get(){
		return employeeService.get();
	}
	
	// used to save or update the table
	@PostMapping("/addEmployee")
	public Employee save(@RequestBody Employee employeeObject) {
		employeeService.save(employeeObject);
		return employeeObject;
		
	}
	
	// to give path variable use {}
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id){
     Employee employeeobj = employeeService.get(id);
     if(employeeobj==null) {
    	 throw new RuntimeException("Employee with id : " +id + " not found");
     }
		return employeeService.get(id);
		};
	
		
   @DeleteMapping("/employee/{id}")
   public String delete(@PathVariable int id) {
	   return employeeService.delete(id);
   }
	
	
}
