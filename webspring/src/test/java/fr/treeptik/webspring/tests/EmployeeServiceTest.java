package fr.treeptik.webspring.tests;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.treeptik.webspring.model.Department;
import fr.treeptik.webspring.repositories.DepartmentDAO;
import fr.treeptik.webspring.services.DepartmentService;

public class EmployeeServiceTest {

	private static DepartmentService departmentService;
	private static DepartmentDAO mockDAO;
	
	private Department department;
	private List<Department> listDepartments;

	@BeforeClass
	public static void SetUpBeforeClass() throws Exception {
		mockDAO = createMock(DepartmentDAO.class);
		departmentService = new DepartmentService();
		departmentService.setDAO(mockDAO);
	}
	
	@Before
	public void setUp() throws Exception {
		department = new Department();
		listDepartments = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		department.setName("Test Department (mock)");
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
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

}
