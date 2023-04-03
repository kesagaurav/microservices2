package com.gaurav.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.dto.CompanyDTO;
import com.gaurav.model.Company;
import com.gaurav.repository.CompanyRepository;
import com.gaurav.service.CompanyService;

import java.util.*;


@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository compRepository;


	@Override
	public Company saveCompany(CompanyDTO cDTO) {
		Company c = new Company();
		c = cDTO.dtoToCompany();
		// TODO Auto-generated method stub
		CompanyDTO companyToDto = cDTO.companyToDto(c);
		cDTO=companyToDto;

		 return compRepository.save(c);
	}


	@Override
	public CompanyDTO getEmployeeById(int id) {
		CompanyDTO eDto=null;
		Optional<Company> e=compRepository.findById(id);
		if(e.isPresent()) {
			eDto=eDto.companyToDto(e.get());
		}
		return eDto;
	}


	@Override
	public List<CompanyDTO> getAllCompanies() {
		// TODO Auto-generated method stub
		Company c=new Company();
		List<Company> compList=new ArrayList<>();
		List<CompanyDTO> compDTO=new ArrayList<>();
		compList = compRepository.findAll();
		return compList.stream().map(CompanyDTO::companyToDto).collect(Collectors.toList());
	}

}
