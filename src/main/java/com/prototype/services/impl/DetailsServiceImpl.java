package com.prototype.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.model.ContactDetails;
import com.prototype.model.Details;
import com.prototype.model.PersonalDetails;
import com.prototype.model.User;
import com.prototype.repositories.AcademicRepository;
import com.prototype.repositories.ContactDetailsRepository;
import com.prototype.repositories.PersonalDetailsRepository;
import com.prototype.repositories.UserRepository;
import com.prototype.repositories.UsersRepository;
import com.prototype.services.DetailsService;
import com.prototype.services.MyUserDetailsService;

@Service
public class DetailsServiceImpl implements DetailsService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private AcademicRepository academicRepository;
	
	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;
	
	@Autowired
	private ContactDetailsRepository contactDetailsRepository;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Details details() {
		
		Details dts=new Details();
		User usr= new User();
		
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		
		dts.enlst =usersRepository.findById(usr.getEnlst().getId());
		dts.academicDetails1=academicRepository.findAllByEnlstId(usr.getEnlst().getId());
		return dts; 
 }
	
	@Override
	public boolean delDetails() {
		long id;
		long personal_details_id;
		long contact_details_id;
		User usr= new User();
		
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		id=usr.getEnlst().getId();
		personal_details_id=usr.getPersonalDetails().getId();
		contact_details_id=usr.getContactDetails().getId();

	    usr.setEnlst(null);
	    usr.setPersonalDetails(null);
	    usr.setContactDetails(null);
		
		userRepository.save(usr);
		
		usersRepository.deleteById(id);
		academicRepository.deleteAllByEnlstId(id);
		personalDetailsRepository.deleteById(personal_details_id);
		contactDetailsRepository.deleteById(contact_details_id);
		return true; 
 }

	@Override
	public PersonalDetails personalDetails() {
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		return personalDetailsRepository.findByAppId(usr.getAppId());
	}

	@Override
	public ContactDetails contactDetails() {
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		return contactDetailsRepository.findByAppId(usr.getAppId());
	}
}