package com.aprovechaesbesin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aprovechaesbesin.entity.Country;

@Repository
public interface CountryRepository extends MongoRepository<Country, String>{
	
	
}
