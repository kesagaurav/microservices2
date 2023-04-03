package com.gaurav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.dto.EmployeeDTO;
import com.gaurav.model.Employee;
import com.gaurav.service.EmployeeService;
import com.gaurav.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController{
	@Autowired
	private EmployeeService empService;

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody EmployeeDTO eDTO) {
		// TODO Auto-generated method stub
		return empService.saveEmployee(eDTO);
	}

	@GetMapping("/employee/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return empService.getEmployeeById(id);
	}

	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		return empService.getAllEmployees();
	}

}
