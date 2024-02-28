package com.prototype.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.model.ContactDetails;
import com.prototype.model.Details;
import com.prototype.model.PersonalDetails;
import com.prototype.services.DetailsService;

@RestController
@RequestMapping("/api") 
public class DetailsController {
	
	@Autowired
	private DetailsService detailsService;

	@GetMapping("/getPersonalDetails")
	public PersonalDetails personalDetails() {
	return detailsService.personalDetails();
	}
	
	@GetMapping("/getContactDetails")
	public ContactDetails contactDetails() {
	return detailsService.contactDetails();
	}
	
	@GetMapping("/details")
	public Details details() {
	return detailsService.details();
	}
	
	@DeleteMapping("/delDetails")
	public boolean delDetails() {
	return detailsService.delDetails();
	}
}