package com.example.demo.Controller;

import java.util.Optional;

import com.example.demo.Vehicule;
import com.example.demo.Repository.VehiculeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculeController {
    VehiculeRepository vehiculeRepository;

    @Autowired
    public VehiculeController(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }
   
    @GetMapping(value="/vehicules")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Vehicule> ListeLocations() {
        return vehiculeRepository.findAll();
    }

    @GetMapping("/vehicules/{plaque}")
	public Vehicule getVehicule(@PathVariable(value = "plaque") String plaque){
		if(plaque!=null) {
            return vehiculeRepository.findById(plaque).get();
        }
        return null;
	}
}
