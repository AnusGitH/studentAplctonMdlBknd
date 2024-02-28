package com.prototype.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.model.ContactDetails;
import com.prototype.repositories.ContactDetailsRepository;
import com.prototype.services.ContactDetailsService;
import com.prototype.services.MyUserDetailsService;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {
	
	@Autowired
	private ContactDetailsRepository contactDetailsRepository;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;

	@Override
	public ContactDetails contactDetails(ContactDetails contactDetails) {
		contactDetails.setAppId(myUserDetailsService.usr().getAppId());
		return contactDetailsRepository.save(contactDetails);
	}
}