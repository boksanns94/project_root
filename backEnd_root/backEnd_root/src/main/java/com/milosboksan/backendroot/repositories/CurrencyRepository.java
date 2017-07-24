package com.milosboksan.backendroot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.milosboksan.backendroot.entities.CurrencyEntity;

/*
 * 
 * CurrencyRepository - Currency database table.
 * Author: Milos Boksan
 * Created on: 15:49 24.07.2017.
 */

public interface CurrencyRepository extends CrudRepository<CurrencyEntity, Integer>{

}
