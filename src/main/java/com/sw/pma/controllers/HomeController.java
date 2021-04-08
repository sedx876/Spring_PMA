package com.sw.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sw.pma.dao.EmployeeRepository;
import com.sw.pma.dao.ProjectRepository;
import com.sw.pma.entities.Employee;
import com.sw.pma.entities.Project;





@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository emRepo;


	@GetMapping("/")
	public String displayHome(Model model) {
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		List<Employee> employees = emRepo.findAll();
		model.addAttribute("employees", employees);
		
		return "main/home";
	}
}