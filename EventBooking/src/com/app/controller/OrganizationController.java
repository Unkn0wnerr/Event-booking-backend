package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IOrganizerDao;
import com.app.pojo.Organization;
import com.app.pojo.User;

@RestController
@RequestMapping("/org")
@CrossOrigin("*")
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
			System.out.println(o);
			System.out.println("In register org ");
			return dao.registerOrg(o);
		}
		@PostMapping("/validate")
		public ResponseEntity<?> validateOrg(@RequestBody Organization o)
		{
			System.out.println("In register org ");
			Organization a= dao.authenticateOrg(o.getOrgEmail(), o.getOrgPassword());
			 return new ResponseEntity<Organization>(a, HttpStatus.OK);
		}
	
		@GetMapping("/list")
		public List<Organization> getAllOrg()
		{
			return dao.getAllOrg();
		}
	
}
