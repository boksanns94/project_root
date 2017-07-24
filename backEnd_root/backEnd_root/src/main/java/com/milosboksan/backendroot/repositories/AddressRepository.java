package com.milosboksan.backendroot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.milosboksan.backendroot.entities.AddressEntity;

/*
 * 
 * AddressRepository - AddressEntity database table.
 * Author: Milos Boksan
 * Created on: 14:15 24.07.2017.
 */

public interface AddressRepository extends CrudRepository<AddressEntity, Integer>
{
	AddressEntity findByCountryNameAndStateNameAndPostalCodeAndCityNameAndStreetNumberAndStreetName(String countryName, String stateName, String postalCode, String cityName, String streetNumber, String streetName);
	Boolean existsByCountryNameAndStateNameAndPostalCodeAndCityNameAndStreetNumberAndStreetName(String countryName, String stateName, String postalCode, String cityName, String streetNumber, String streetName);
}
