package com.prototype.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.model.PersonalDetails;
import com.prototype.services.PersonalDetailsService;

@RestController
@RequestMapping("/api") 
public class PersonalDetailsController {

	@Autowired
	private PersonalDetailsService personalDetailsService;
	
	@PostMapping("/personalDetails")
	public PersonalDetails PersonalDetails(@RequestBody PersonalDetails personalDetails) {
	  return personalDetailsService.personalDetails(personalDetails);
	}
}