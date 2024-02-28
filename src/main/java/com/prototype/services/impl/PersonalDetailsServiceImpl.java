package com.prototype.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.model.PersonalDetails;
import com.prototype.repositories.PersonalDetailsRepository;
import com.prototype.services.MyUserDetailsService;
import com.prototype.services.PersonalDetailsService;

@Service
public class PersonalDetailsServiceImpl implements PersonalDetailsService {

	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Override
	public PersonalDetails personalDetails(PersonalDetails personalDetails) {
		personalDetails.setAppId(myUserDetailsService.usr().getAppId());
		return personalDetailsRepository.save(personalDetails);
	}
}