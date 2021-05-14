package com.jeffersonamaral.citiesapi.cities.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonamaral.citiesapi.cities.entities.City;
import com.jeffersonamaral.citiesapi.cities.repositories.CityRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("cities")
public class CityResource {

    private final CityRepository repository;

    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }
    
    @GetMapping("/{id}")
    public City getOne(@PathVariable("id") Long id) {
        return repository.findById(id).get();
    }
    
}