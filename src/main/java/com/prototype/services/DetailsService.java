package com.prototype.services;

import com.prototype.model.ContactDetails;
import com.prototype.model.Details;
import com.prototype.model.PersonalDetails;

public interface DetailsService {
 Details details();
 PersonalDetails personalDetails();
 ContactDetails contactDetails();
 boolean delDetails();
}
