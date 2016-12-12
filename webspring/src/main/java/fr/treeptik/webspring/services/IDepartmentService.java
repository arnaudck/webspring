package fr.treeptik.webspring.services;

import java.util.List;

import fr.treeptik.webspring.model.Department;

public interface IDepartmentService {

	public Department create(Department department);
	
	public Department findById(Long id);
	
	public Department update(Department department);
	
	public void delete(Department department);
	
	public List<Department> findAll();
	
}
