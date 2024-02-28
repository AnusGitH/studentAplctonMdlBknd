package com.prototype.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.model.SubmitDetails;
import com.prototype.services.SubmitDetailsService;

@RestController
@RequestMapping("/api") 
public class SubmitDetailsController {
	@Autowired
	private SubmitDetailsService submitDetailsService;
	
	@PostMapping("/submitDetails")
	public boolean submitDetails(@RequestBody String chkAck,SubmitDetails submitDetails) {
		return submitDetailsService.submitDetails(chkAck,submitDetails);
	}
}