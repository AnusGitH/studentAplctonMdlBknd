package com.prototype.controllers;                                                                               

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.services.CourseEnlistService;

@RestController
@RequestMapping("/api") 
public class CourseEnlistController {

	@Autowired
	private CourseEnlistService courseEnlistService;
	
	@PostMapping("/courseEnlist")
	public boolean courseEnlist( @RequestBody Enac enac) {
	courseEnlistService.studentCourseEnlist(enac.enlst, enac.acdt);
	return true;
	}
}                                                                    