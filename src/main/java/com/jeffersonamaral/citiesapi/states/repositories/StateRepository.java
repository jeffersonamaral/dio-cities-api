package com.jeffersonamaral.citiesapi.states.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeffersonamaral.citiesapi.states.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}