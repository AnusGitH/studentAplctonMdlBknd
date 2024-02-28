package com.prototype.repositories;

import org.springframework.data.repository.CrudRepository;

import com.prototype.model.UploadDetails;

public interface UploadRepository extends CrudRepository<UploadDetails, String> {
	UploadDetails findByAppId(String appId);
	boolean existsByAppId(String appId);
	boolean deleteByAppId(String appId);
}
