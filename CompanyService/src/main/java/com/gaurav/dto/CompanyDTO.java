package com.gaurav.dto;

import com.gaurav.model.Company;


import lombok.Data;

@Data
public class CompanyDTO {
	private int comid;
	private String name;
	private String loc;
	
	public Company dtoToCompany() {
		Company c=new Company ();
		c.setComid(this.getComid());
		c.setName(this.getName());
		c.setLoc(this.getLoc());
		return c;
	}
	
	
	
	public static CompanyDTO companyToDto(Company comp) {
		CompanyDTO eDTO=new CompanyDTO();
		eDTO.setComid(comp.getComid());
		eDTO.setName(comp.getName());
		eDTO.setLoc(comp.getLoc());
		return eDTO;
	}
}
//