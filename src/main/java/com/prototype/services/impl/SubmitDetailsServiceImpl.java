package com.prototype.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.model.SubmitDetails;
import com.prototype.repositories.SubmitDetailsRepository;
import com.prototype.services.MyUserDetailsService;
import com.prototype.services.SubmitDetailsService;

@Service
public class SubmitDetailsServiceImpl implements SubmitDetailsService {

	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private SubmitDetailsRepository submitDetailsRepository;

	@Override
	public boolean submitDetails(String chkAck,SubmitDetails submitDetails) {
		submitDetails.setAppId(myUserDetailsService.usr().getAppId());
		submitDetails.setAckChk(chkAck);
		submitDetails.setChkAck(null);
		submitDetailsRepository.save(submitDetails);
		if(chkAck.matches("AckChk")) {
			return true;
		} else {
			return false;
		}
	}
}