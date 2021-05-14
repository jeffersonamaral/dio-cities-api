package com.jeffersonamaral.citiesapi.cities.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeffersonamaral.citiesapi.cities.service.DistanceService;
import com.jeffersonamaral.citiesapi.cities.service.EarthRadius;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/distances")
public class DistanceResource {

    private static final Logger LOG = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService service;

    @GetMapping("/by-points")
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2) {
        LOG.info("byPoints");
        
        return ResponseEntity.ok(service.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/by-cube")
    public ResponseEntity<Double> byCube(@RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2) {
        LOG.info("byCube");
        
        return ResponseEntity.ok(service.distanceByCubeInMeters(city1, city2));
    }

    @GetMapping("/by-math")
    public ResponseEntity<Double> byMath(@RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2,
            @RequestParam final EarthRadius unit) {
        LOG.info("byMath");
        
        return ResponseEntity.ok(service.distanceUsingMath(city1, city2, unit));
    }
}
