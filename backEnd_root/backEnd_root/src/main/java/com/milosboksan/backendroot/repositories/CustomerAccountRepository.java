package com.milosboksan.backendroot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.milosboksan.backendroot.entities.CustomerAccountEntity;

/*
 * 
 * CustomerAccountRepository - Customer accounts database table.
 * Author: Milos Boksan
 * Created on: 15:51 24.07.2017.
 */

public interface CustomerAccountRepository extends CrudRepository<CustomerAccountEntity, Integer>
{
	List<CustomerAccountEntity> findByOwnerUsername(String username);
	Boolean existsByAccountNumber(String accountNumber);
	CustomerAccountEntity findByAccountNumber(String accountNumber);
}
