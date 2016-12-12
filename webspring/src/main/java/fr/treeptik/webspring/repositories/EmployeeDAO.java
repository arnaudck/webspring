package fr.treeptik.webspring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.treeptik.webspring.model.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.lastName=:lastName")
	List<Employee> findByLastName(@Param("lastName") String lastName);
	
	@Query("SELECT e FROM Employee e WHERE e.firstName=:firstName")
	List<Employee> findByFirstName(@Param("firstName") String firstName);
	
}
