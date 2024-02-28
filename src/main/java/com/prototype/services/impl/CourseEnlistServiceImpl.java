package com.prototype.services.impl;

import com.prototype.controllers.Acdt;
import com.prototype.model.Enlist;
import com.prototype.repositories.AcademicRepository;
import com.prototype.repositories.UsersRepository;
import com.prototype.services.CourseEnlistService;
import com.prototype.services.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseEnlistServiceImpl implements CourseEnlistService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private AcademicRepository academicRepository;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Override
	public Enlist studentCourseEnlist(Enlist enlst, Acdt acdt) {
	for(int i=0;i<=acdt.academicDetails.length-1;i++) {
    enlst.getAcademicDetails().add(acdt.academicDetails[i]);
 	acdt.academicDetails[i].setEnlst(enlst); 
	}
	
	enlst.setAppId(myUserDetailsService.usr().getAppId());

	Enlist llkg= usersRepository.save(enlst);
	academicRepository.saveAll(enlst.getAcademicDetails());
	
	return llkg;
	}
}