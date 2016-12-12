package fr.treeptik.webspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.webspring.model.Employee;
import fr.treeptik.webspring.repositories.EmployeeDAO;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Transactional
	public Employee create(Employee employee) {
		return employeeDAO.save(employee);
	}

	public Employee findById(Long id) {
		return employeeDAO.findOne(id);
	}

	@Transactional
	public Employee update(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Transactional
	public void delete(Employee employee) {
		employeeDAO.delete(employee);
	}

	public List<Employee> findAll() {
		return (List<Employee>) employeeDAO.findAll();
	}
	
	public List<Employee> findByLastName(String lastName) {
		return (List<Employee>) employeeDAO.findByLastName(lastName);
	}
	
	public List<Employee> findByFirstName(String firstName) {
		return (List<Employee>) employeeDAO.findByFirstName(firstName);
	}
	
}
