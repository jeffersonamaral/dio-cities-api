package com.jeffersonamaral.citiesapi.countries.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonamaral.citiesapi.countries.entities.Country;
import com.jeffersonamaral.citiesapi.countries.repositories.CountryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/countries")
public class CountryResource {

    private final CountryRepository repository;

    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable("id") Long id) {
        Optional<Country> country = repository.findById(id);
        
        if (country.isPresent()) {
            return ResponseEntity.ok().body(country.get()); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}