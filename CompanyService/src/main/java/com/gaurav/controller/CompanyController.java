package com.gaurav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.dto.CompanyDTO;
import com.gaurav.model.Company;
import com.gaurav.service.CompanyService;


@RestController
public class CompanyController{
	@Autowired
	private CompanyService compService;

	@PostMapping("/company")
	public Company saveCompany(@RequestBody CompanyDTO eDTO) {
		// TODO Auto-generated method stub
		return compService.saveCompany(eDTO);
	}

	@GetMapping("/company/{id}")
	public CompanyDTO getEmployeeById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return compService.getEmployeeById(id);
	}

	@GetMapping("/companies")
	public List<CompanyDTO> getAllCompanies() {
		// TODO Auto-generated method stub
		return compService.getAllCompanies();
	}

}
