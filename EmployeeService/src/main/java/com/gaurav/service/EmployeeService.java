package com.gaurav.service;
import java.util.*;
import com.gaurav.dto.EmployeeDTO;
import com.gaurav.model.Employee;

public interface EmployeeService {
	public void saveEmployee(EmployeeDTO eDTO);
	public EmployeeDTO getEmployeeById(int id);
	List<EmployeeDTO> getAllEmployees();
}
