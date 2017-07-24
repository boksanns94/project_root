package com.milosboksan.backendroot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.milosboksan.backendroot.entities.BankEntity;

/*
 * 
 * BankRepository - BankEntity database table.
 * Author: Milos Boksan
 * Created on: 14:29 24.07.2017.
 */

public interface BankRepository extends CrudRepository<BankEntity, Integer>
{
	BankEntity findByBankName(String bankName);
	Boolean existsByBankName(String bankName);
	BankEntity findByBankIdNumber(String bankIdNumber);
	Boolean existsByBankIdNumber(String bankIdNumber);
}
