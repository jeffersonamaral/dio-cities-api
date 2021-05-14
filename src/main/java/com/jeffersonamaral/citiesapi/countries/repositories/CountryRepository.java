package com.jeffersonamaral.citiesapi.countries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeffersonamaral.citiesapi.countries.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}