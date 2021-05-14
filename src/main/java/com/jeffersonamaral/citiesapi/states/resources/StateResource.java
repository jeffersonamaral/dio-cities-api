package com.jeffersonamaral.citiesapi.states.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonamaral.citiesapi.states.entities.State;
import com.jeffersonamaral.citiesapi.states.repositories.StateRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/states")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StateResource {

    private final StateRepository repository;

    @GetMapping
    public Page<State> states(Pageable page) {
        return repository.findAll(page);
    }
    
    @GetMapping("/{id}")
    public State getOne(@PathVariable("id") Long id) {
        return repository.findById(id).get();
    }
    
}