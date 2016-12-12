package fr.treeptik.webspring.services;

import java.util.List;

import fr.treeptik.webspring.model.Employee;

public interface IEmployeeService {

	public Employee create(Employee employee);
	
	public Employee findById(Long id);
	
	public Employee update(Employee employee);
	
	public void delete(Employee employee);
	
	public List<Employee> findAll();
}
