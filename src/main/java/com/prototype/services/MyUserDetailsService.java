package com.prototype.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prototype.currentuser.UserPrincipal;
import com.prototype.model.User;
import com.prototype.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	User usr1= new User();
		
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 User user=repo.findByUsername(username);
		 usr1=user;
				 if(user==null) 
			      throw new UsernameNotFoundException("User 404");
				 return new UserPrincipal(user);
	}
	
	public User usr() {
		return usr1;
	}
}