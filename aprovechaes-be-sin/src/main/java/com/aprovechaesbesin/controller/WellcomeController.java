package com.aprovechaesbesin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aprovechaesbesin.entity.Country;
import com.aprovechaesbesin.repository.CountryRepository;

//@RestController
@Controller
//@RequestMapping("/wellcome")
public class WellcomeController {
	
	@Autowired 
	private CountryRepository countryRepository;
	
	@GetMapping("/") 
	public String getBody(Model model, @RequestParam(defaultValue="0")int page) {		
		System.out.println("=>100A page: "+page);
		model.addAttribute("data", countryRepository.findAll( PageRequest.of(page, 4, Sort.by("name").descending())));
		model.addAttribute("currentPage", page);
		return "index";
	}
	
	@PostMapping("/save")
	public String save(Country country) {
		System.out.println("save: "+country.getId() +" - "+country.getName() +" - "+country.getCapital());
		if(country.getId() == null || country.getId().length()<=0) {
			Country c = new Country(country.getName(), country.getCapital());
			countryRepository.save(c);
		}else
		countryRepository.save(country);		
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(String id) {
		countryRepository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Country findOne(String id) {
		System.out.println("id: "+id);
		Optional<Country> optionalEntity = countryRepository.findById(id);
		System.out.println("found: "+optionalEntity.get().getId() +" - "+optionalEntity.get().getName());
		return optionalEntity.get();
	}
	
}
