package com.prototype.repositories;

import org.springframework.data.repository.CrudRepository;

import com.prototype.model.TstiDetails;

public interface TstiRepository1 extends CrudRepository<TstiDetails, Long> {
	TstiDetails[] findAllByUploadDetailsAppId(String appId);
	boolean existsByUploadDetailsAppId(String appId);
	void deleteAllByUploadDetailsAppId(String appId);
}
