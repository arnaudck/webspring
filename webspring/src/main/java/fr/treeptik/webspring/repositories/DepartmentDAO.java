package fr.treeptik.webspring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.treeptik.webspring.model.Department;

@Repository // Ne pas utiliser avec Spring-data
public interface DepartmentDAO extends CrudRepository<Department, Long> {

	@Query("SELECT d FROM Department d WHERE d.name=:name")
	List<Department> findByName(@Param("name") String name);
	
}
