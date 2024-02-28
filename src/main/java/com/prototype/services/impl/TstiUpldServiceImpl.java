package com.prototype.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.controllers.Tstdt;
import com.prototype.controllers.Tstdt1;
import com.prototype.model.TDetails;
import com.prototype.model.UploadDetails;
import com.prototype.model.User;
import com.prototype.repositories.TstiRepository;
import com.prototype.repositories.TstiRepository1;
import com.prototype.repositories.UploadRepository;
import com.prototype.repositories.UserRepository;
import com.prototype.services.MyUserDetailsService;
import com.prototype.services.TstiService;

import jakarta.transaction.Transactional;

@Service
public class TstiUpldServiceImpl implements TstiService {
	
	@Autowired
	private TstiRepository tstiRepository;
	
	@Autowired
	private TstiRepository1 tstiRepository1;
	
	@Autowired
	private UploadRepository uploadRepository;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private UserRepository userRepository;
	
	TDetails tdts=new TDetails();
	
	Tstdt tstdt1=new Tstdt();
	
	Tstdt1 tstdt11=new Tstdt1();
	
	@Override
	public boolean tstiUpldStat() {
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		if(tstiRepository1.existsByUploadDetailsAppId(usr.getAppId())) {	
			return true;
		}else {
			return false;    
		}
	}

	@Override
	public boolean uploadTsti(Tstdt tstdt, UploadDetails upDtls) {
	User usr= new User();
	usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
	
	upDtls=uploadRepository.findByAppId(usr.getAppId());
		
	for(int i=0;i<=tstdt.tstiDetails.length-1;i++) {
	upDtls.getTstiDetails().add(tstdt.tstiDetails[i]);
	tstdt.tstiDetails[i].setUploadDetails(upDtls);
	}
	tstdt1=tstdt;
	tstiRepository.saveAll(upDtls.getTstiDetails());
	return false;
	}
	
	@Override
	public Tstdt tDetails() {
		User usr= new User();	
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		tstdt1.tstiDetails1=tstiRepository.findAllByUploadDetailsAppId(usr.getAppId());	
		return tstdt1; 
	}

	@Override
	@Transactional
	public boolean delTsti() {
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
	 tstiRepository.deleteAllByUploadDetailsAppId(usr.getAppId());
	 return true;
	}

	@Override
	public boolean uploadTsti1(Tstdt1 tstdt, UploadDetails upDtls) {
		
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		
		upDtls=uploadRepository.findByAppId(usr.getAppId());
			
		for(int i=0;i<=tstdt.tstiDetails.length-1;i++) {
		upDtls.getTstiDetails().add(tstdt.tstiDetails[i]);
		tstdt.tstiDetails[i].setUploadDetails(upDtls);
		}
		tstiRepository1.saveAll(upDtls.getTstiDetails());
		return false;
	}

	@Override
	public Tstdt1 tDetails1() {
		
		User usr= new User();	
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		tstdt11.tstiDetails1=tstiRepository1.findAllByUploadDetailsAppId(usr.getAppId());	
		return tstdt11;
	}
}