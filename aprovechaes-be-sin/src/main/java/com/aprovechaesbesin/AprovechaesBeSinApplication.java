package com.aprovechaesbesin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aprovechaesbesin.entity.Country;
import com.aprovechaesbesin.repository.CountryRepository;

@SpringBootApplication
public class AprovechaesBeSinApplication implements CommandLineRunner {
	
	@Autowired(required=true)
	CountryRepository countryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AprovechaesBeSinApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		countryRepository.deleteAll();
		countryRepository.save(new Country("USA", "DC"));
		countryRepository.save(new Country("Germany", "Berlin"));
		countryRepository.save(new Country("China", "Pekin"));
		countryRepository.save(new Country("Brasil", "Brasilia"));
		countryRepository.save(new Country("Uruguay", "Montevideo"));
		countryRepository.save(new Country("India", "Nueva Dheli"));
		countryRepository.save(new Country("Russia", "Moscow"));
		countryRepository.save(new Country("Mexico", "cdmx"));
		countryRepository.save(new Country("Cannada", "Otawwa"));
		countryRepository.save(new Country("Earth", "World"));
		countryRepository.save(new Country("Egipt", "cairo"));
		countryRepository.save(new Country("Afganistan", "Kabul"));
		countryRepository.save(new Country("Costa Rica", "San Jose"));
		countryRepository.save(new Country("Spain", "Madrid"));
		countryRepository.save(new Country("Italy", "Rome"));
		countryRepository.save(new Country("UK", "Londres"));
		countryRepository.save(new Country("France", "Paris"));
		countryRepository.save(new Country("Japan", "Tokio"));
		countryRepository.save(new Country("Argentina", "Buenos Aires"));
	}
	
	

}

