package com.example.demo.Controller;

import java.util.Optional;

import com.example.demo.Location;
import com.example.demo.Repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    LocationRepository locationRepository;

    @Autowired
    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
   
    
    @GetMapping(value="/locations")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Location> ListeLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/locations/{idLocation}")
	public Location getLocation(@PathVariable(value = "idLocation") int idLocation){
		
        return locationRepository.findById(idLocation).get();
	}
}
