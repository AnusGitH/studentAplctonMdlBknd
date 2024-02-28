package com.prototype.repositories;

import org.springframework.data.repository.CrudRepository;

import com.prototype.model.AcademicDetails;

public interface AcademicRepository extends CrudRepository<AcademicDetails, Long> {
 AcademicDetails findByEnlstId(Long id);
 AcademicDetails[] findAllByEnlstId(Long enlst);
 void deleteAllByEnlstId(Long enlst);
}
