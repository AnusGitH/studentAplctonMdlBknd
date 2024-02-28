package com.prototype.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.model.UploadDetails;
import com.prototype.model.User;
import com.prototype.repositories.UploadRepository;
import com.prototype.repositories.UserRepository;
import com.prototype.services.MyUserDetailsService;
import com.prototype.services.UploadService;

@Service
public class ImageUploadImpl implements UploadService {

	@Autowired
	private UploadRepository uploadRepository;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean uploadImage(UploadDetails upDtls) {
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		
		upDtls.setAppId(usr.getAppId());
		
		uploadRepository.save(upDtls);
		return true;
	}
	
	@Override
	public boolean imgUpldStat() {
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		if(uploadRepository.existsByAppId(usr.getAppId())) {	
		if(uploadRepository.findByAppId(usr.getAppId()).getImg_pic_byte()!=null)
		{
			return true;
		}else {
			return false;
		}
		}else {
			return false;    
		}
	}
	
	@Override
	public boolean uploadSig(UploadDetails upDtls) {
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		
		upDtls.setAppId(usr.getAppId());
		
    	uploadRepository.save(upDtls);
		return true;
	}
	
	@Override
	public boolean sigUpldStat() {
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		if(uploadRepository.existsByAppId(usr.getAppId())) {	
			if(uploadRepository.findByAppId(usr.getAppId()).getSig_pic_byte()!=null)
			{
				return true;
			}else {
				return false;
			}
			}else {
				return false;    
			}
	}

	@Override
	public Optional<UploadDetails> getImg() {
        User usr= new User();
        UploadDetails upDtls=new UploadDetails();
		
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		upDtls= uploadRepository.findByAppId(usr.getAppId());
		
		return Optional.of(upDtls);
	}
	
	@Override
	public Optional<UploadDetails> getSig() {
        User usr= new User();
        UploadDetails upDtls=new UploadDetails();
		
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
		upDtls= uploadRepository.findByAppId(usr.getAppId());
		
		return Optional.of(upDtls);
	}
	
	@Override
	public boolean delUpload() {
		User usr= new User();
		usr=userRepository.findByUsername(myUserDetailsService.usr().getUsername());
        uploadRepository.deleteById(usr.getAppId());
		return true;
	 }
}