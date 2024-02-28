package com.prototype.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.model.ContactDetails;
import com.prototype.services.ContactDetailsService;

@RestController
@RequestMapping("/api") 
public class ContactDetailsController {
	@Autowired
	private ContactDetailsService contactDetailsService;
	
	@PostMapping("/contactDetails")
	public ContactDetails ContactDetails(@RequestBody ContactDetails contactDetails) {
	  return contactDetailsService.contactDetails(contactDetails);
	}
}