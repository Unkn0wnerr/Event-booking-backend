package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IOrganizerDao;
import com.app.pojo.Organization;

@RestController
@RequestMapping("/org")
public class OrganizationController {

	
	@Autowired
	private IOrganizerDao dao;
	
	public OrganizationController() {
		System.out.println("Inside OrgController Contructor");
		}
		
		@GetMapping("/{org_id}")
		public Organization getOrgDetail(@PathVariable int org_id)
		{
			System.out.println("In get org details "+org_id);
			
			return dao.getOrgDetails(org_id);
		}
		
		@PostMapping("/register")
		public Organization registerOrg(@RequestBody Organization o)
		{
			System.out.println("In register org ");
			return dao.registerOrg(o);
		}
		@PostMapping("/validate")
		public Organization validateOrg(@RequestParam String email,@RequestParam String password)
		{
			System.out.println("In register org ");
			return dao.authenticateOrg(email, password);
		}
	
	
}
