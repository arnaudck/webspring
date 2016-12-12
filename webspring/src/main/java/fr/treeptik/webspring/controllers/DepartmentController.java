package fr.treeptik.webspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.treeptik.webspring.model.Department;
import fr.treeptik.webspring.services.IDepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	IDepartmentService departmentService;
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/getAllDepartments", method=RequestMethod.GET, headers="Accept=application/json")
	public String getAllDepartments(Model model) {
		List<Department> listDepartments = departmentService.findAll();
		model.addAttribute("department", new Department());
		model.addAttribute("listDepartments", listDepartments);
		return "departmentDetails";
	}
	
	@RequestMapping(value="/getDepartment/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public Department getDepartmentById(@PathVariable long id) {
		return departmentService.findById(id);
	}
	
	@RequestMapping(value="/addDepartment", method=RequestMethod.POST, headers="Accept=application/json")
	public String addDepartment(@ModelAttribute("department") Department department) {
		if (department.getId() == 0) {
			departmentService.create(department);
		} else {
			departmentService.update(department);
		}
		return "redirect:/getAllDepartments";
	}
	
	@RequestMapping(value="/updateDepartment/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public String updateDepartment(@PathVariable long id, Model model) {
		model.addAttribute("department", this.departmentService.findById(id));
		model.addAttribute("listDepartments", this.departmentService.findAll());
		return "departmentDetails";
	}
	
	@RequestMapping(value="/deleteDepartment/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public String deleteDepartment(@PathVariable long id) {
		departmentService.delete(departmentService.findById(id));
		return "redirect:/getAllDepartments";
	}
	
}
