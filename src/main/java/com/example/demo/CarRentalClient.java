package com.example.demo;

import java.util.List;

import com.example.demo.Entity.Vehicule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class CarRentalClient {
	
	private static final Logger log = LoggerFactory.getLogger(CarRentalClient.class);

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<Vehicule> request = new HttpEntity<>(new Vehicule("44QQ66", "Peugeot", 12));
		restTemplate.postForObject("http://localhost:8080/cars", request, Vehicule.class);
		
        List cars = restTemplate.getForObject("http://localhost:8080/cars", List.class);
        log.info(cars.toString());
        
	}

}