package fr.treeptik.webspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.webspring.model.Department;
import fr.treeptik.webspring.repositories.DepartmentDAO;

@Service
public class DepartmentService implements IDepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	public void setDAO(DepartmentDAO dao) {
		this.departmentDAO = dao;
	}

	@Transactional
	public Department create(Department department) {
		return departmentDAO.save(department);
	}

	public Department findById(Long id) {
		return departmentDAO.findOne(id);
	}

	@Transactional
	public Department update(Department department) {
		return departmentDAO.save(department);
	}

	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void delete(Department department) {
		departmentDAO.delete(department);
	}

	public List<Department> findAll() {
		return (List<Department>) departmentDAO.findAll();
	}
	
	public List<Department> findByName(String name) {
		return (List<Department>) departmentDAO.findByName(name);
	}

}
