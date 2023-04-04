package com.gaurav.dto;

import com.gaurav.model.Employee;

import lombok.Data;
import java.util.*;
import com.gaurav.model.*;

@Data
public class EmployeeDTO {
	private int empid;
	private String name;
	private String desc;
	private int compId;
	private CompanyDTO setCompany;
	
	
	public  Employee dtoToEmployee() {
		Employee e=new Employee();
		e.setEmpid(this.getEmpid());
		e.setName(this.getName());
		e.setDesc(this.getDesc());
		e.setCompId(this.getSetCompany().getComid());
		
		
		return e;
	}
	
	
	
	public static EmployeeDTO employeeToDto(Employee emp) {
		EmployeeDTO eDTO=new EmployeeDTO();
		eDTO.setEmpid(emp.getEmpid());
		eDTO.setName(emp.getName());
		eDTO.setDesc(emp.getDesc());
		CompanyDTO cdto=new CompanyDTO();
		cdto.setComid(emp.getCompId());
		eDTO.setSetCompany(cdto);
		
		return eDTO;
	}
}
//