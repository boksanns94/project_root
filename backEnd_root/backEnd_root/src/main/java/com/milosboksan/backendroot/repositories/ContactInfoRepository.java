package com.milosboksan.backendroot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.milosboksan.backendroot.entities.ContactInfoEntity;

/*
 * 
 * ContactInfoRepository - Contact Info database table.
 * Author: Milos Boksan
 * Created on: 15:15 24.07.2017.
 */

public interface ContactInfoRepository extends CrudRepository<ContactInfoEntity, Integer>
{
	ContactInfoEntity findByEmail(String email);
	Boolean existsByEmail(String email);
	ContactInfoEntity findByPrimaryPhone(String primaryPhone);
	Boolean existsByPrimaryPhone(String primaryPhone);
}
