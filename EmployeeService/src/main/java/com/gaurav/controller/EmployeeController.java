package com.gaurav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gaurav.dto.CompanyDTO;
import com.gaurav.dto.EmployeeDTO;
import com.gaurav.model.Employee;
import com.gaurav.service.EmployeeService;
import com.gaurav.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController{
	@Autowired
	private EmployeeService empService;

	@PostMapping("/employee")
	public void saveEmployee(@RequestBody EmployeeDTO eDTO) {
		// TODO Auto-generated method stub
		 empService.saveEmployee(eDTO);
	}

	@GetMapping("/employee/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable int id) {
		// TODO Auto-generated method stub
		EmployeeDTO eDto=empService.getEmployeeById(id);
		CompanyDTO cDto=new RestTemplate().getForObject("http://localhost:9091/company/5",CompanyDTO.class);
		  
		eDto.setSetCompany(cDto);
		return eDto;
	}

	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		return empService.getAllEmployees();
	}

}
