package com.prototype.services;

import com.prototype.controllers.Tstdt;
import com.prototype.controllers.Tstdt1;
import com.prototype.model.UploadDetails;

public interface TstiService {
	boolean uploadTsti(Tstdt tstdt, UploadDetails upDtls);
	boolean uploadTsti1(Tstdt1 tstdt, UploadDetails upDtls);
	boolean tstiUpldStat();
	Tstdt tDetails();
	Tstdt1 tDetails1();
	boolean delTsti();
}
