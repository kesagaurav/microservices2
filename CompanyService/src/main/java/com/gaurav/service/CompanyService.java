package com.gaurav.service;
import java.util.*;

import com.gaurav.dto.CompanyDTO;
import com.gaurav.model.Company;


public interface CompanyService {
	public Company saveCompany(CompanyDTO cDTO);
	public CompanyDTO getEmployeeById(int id);
	List<CompanyDTO> getAllCompanies();
}
