package fr.treeptik.webspring.tests;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.treeptik.webspring.model.Department;
import fr.treeptik.webspring.repositories.DepartmentDAO;
import fr.treeptik.webspring.services.DepartmentService;

public class EmployeeServiceTest {

	private DepartmentService departmentService;
	private DepartmentDAO mockDAO;
	
	private Department department;
	private List<Department> listDepartments;

	@Before
	public void setUp() throws Exception {
		mockDAO = createMock(DepartmentDAO.class);
		departmentService = new DepartmentService();
		departmentService.setDAO(mockDAO);
		
		department = new Department();
		listDepartments = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		department.setName("New department");
		expect(mockDAO.save(department)).andReturn(department);
		replay(mockDAO);
		departmentService.create(department);
		verify(mockDAO);
	}
	
	@Test
	public void testFindAll() {
		expect(mockDAO.findAll()).andReturn(listDepartments);
		replay(mockDAO);
		departmentService.findAll();
		verify(mockDAO);
	}

	@Test
	public void testModify() {
		department.setName("New department");
		expect(mockDAO.save(department)).andReturn(department);
		department.setName("Updated department");
		expect(mockDAO.save(department)).andReturn(department);
		replay(mockDAO);
		departmentService.create(department);
		departmentService.update(department);
		verify(mockDAO);
	}

	@Test
	public void testDeleteNonExistingDepartment() {
		mockDAO.delete(department);
		replay(mockDAO);
		departmentService.delete(department);
		verify(mockDAO);
	}

	@Test
	public void testDeleteExistingDepartment() {
		department.setName("New department");
		expect(mockDAO.save(department)).andReturn(department);
		mockDAO.delete(department);
		replay(mockDAO);
		departmentService.create(department);
		departmentService.delete(department);
		verify(mockDAO);
	}

	@Test
	@Ignore
	public void testFindById() {
		department.setName("New department");
		fail("Not yet implemented");
	}

	@Test
	public void testFindByName() {
		department.setName("New department");
		
	}

}
