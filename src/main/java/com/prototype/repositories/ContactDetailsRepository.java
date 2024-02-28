package com.prototype.repositories;

import org.springframework.data.repository.CrudRepository;

import com.prototype.model.ContactDetails;
import com.prototype.model.PersonalDetails;

public interface ContactDetailsRepository extends CrudRepository<ContactDetails, Long> {
	ContactDetails findByAppId(String appId);
}
