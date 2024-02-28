package com.prototype.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.repositories.UserRepository;
import com.prototype.services.MyUserDetailsService;

@RestController
@RequestMapping("/api") 
public class HomeController {

@Autowired
MyUserDetailsService myUserDetailsService;

@Autowired
private UserRepository userRepository;

	@GetMapping("/")
	public Usrd home(Principal principal) {
		
		Usrd usrd=new Usrd();
		if(principal.getName()==null) {
		 usrd.appId= myUserDetailsService.usr().getAppId();
		 usrd.uname=usrd.appId;
		 return usrd;
		}else  {
			usrd.user= principal.getName();
			usrd.appId=myUserDetailsService.usr().getAppId();
			usrd.username=myUserDetailsService.usr().getUsername();
			usrd.uname=usrd.user;
			
			if(userRepository.findByUsername(myUserDetailsService.usr().getUsername()).getEnlst()!=null) {
				usrd.edit=true;
			}else {
				usrd.edit=false;
			}		
			
			return usrd;
	 }
	}
	
	@GetMapping("/lgn")
	public boolean loginPage() {
		return true;
	}
	
	@GetMapping("/logout-success")
	public boolean logoutPage() {
		return true;
	}
	
	@GetMapping("/success")
	public boolean loginPage2(Principal principal) {
			if( principal.getName()!=null)
			{
				return true;
			}
			else {
				return false;
			}
		} 
	
	@RequestMapping("/failed")
	public boolean failedPage()
	{
		return true;
	}
}