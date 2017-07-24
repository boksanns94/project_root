package com.milosboksan.backendroot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.milosboksan.backendroot.entities.ClientEntity;

/*
 * 
 * ClientRepository - ClientEntity database table.
 * Author: Milos Boksan
 * Created on: 14:43 24.07.2017.
 */

public interface ClientRepository extends CrudRepository<ClientEntity, Integer>
{
	ClientEntity findByJmbg(String jmbg);
	Boolean existsByJmbg(String jmbg);
	ClientEntity findByUsername(String username);
	Boolean existsByUsername(String username);
}
