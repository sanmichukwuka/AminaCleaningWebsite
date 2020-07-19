package com.tts.acleaningwebsite.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.acleaningwebsite.model.Scheduler;

@Repository
public interface ACleaningWebsiteRepository extends CrudRepository<Scheduler, Long>{
	public Optional<Scheduler> findById(Long SchedulerId);
}
