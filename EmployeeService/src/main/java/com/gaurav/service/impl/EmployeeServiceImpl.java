package com.gaurav.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import com.gaurav.dto.CompanyDTO;
import com.gaurav.dto.EmployeeDTO;
import com.gaurav.model.Company;
import com.gaurav.model.Employee;
import com.gaurav.repository.EmployeeRepository;
import com.gaurav.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;
	@Autowired
	private RestTemplate restTemplate;


	@Override
	public Employee saveEmployee(EmployeeDTO eDTO) {
		Employee e = new Employee();
		e = eDTO.dtoToEmployee();
		// TODO Auto-generated method stub
		EmployeeDTO employeeToDto = eDTO.employeeToDto(e);
		eDTO=employeeToDto;

		 return empRepository.save(e);
	}


	@Override
	public EmployeeDTO getEmployeeById(int id) {
		EmployeeDTO eDto=null;
		Employee e1=new Employee();
		Optional<Employee> e=empRepository.findById(id);
		//if(e.isPresent()) {
		   eDto=restTemplate.getForObject("http://localhost:9091/company/5",EmployeeDTO.class,e.get());
			CompanyDTO cDto=new RestTemplate().getForObject("http://localhost:9091/company/"+eDto.getSetCompany().getComid(),CompanyDTO.class,e.get());
		   //ResponseEntity<Company> company=restTemplate.getForEntity("http://localhost:9091/company/5", Company.class,e.get());
			//Company c=company.getBody();
			eDto.setSetCompany(cDto);
		//}
		return eDto;
	}


	@Override
	public List<EmployeeDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		List<Employee> empList=new ArrayList<>();
		List<EmployeeDTO> empDTO=new ArrayList<>();
		empList = empRepository.findAll();
		return empList.stream().map(EmployeeDTO::employeeToDto).collect(Collectors.toList());
	}

}
