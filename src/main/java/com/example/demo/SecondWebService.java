package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondWebService {

	/**
	 * pour le request param : http://localhost:8080/voitures?marque=ferrari
	 */
	@GetMapping("/voitures")
	public List<Vehicule> liste(@RequestParam(value = "marque") String brand){
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		vehicules.add(new Vehicule("DD55FF", brand, 10));
		vehicules.add(new Vehicule("EE66GG", brand, 10000));
		System.out.println("Deuxième WS retourne : " + vehicules);
		return vehicules;
	}
	
	@GetMapping("/voitures/{prix}")
	public Vehicule getVoiture(@PathVariable(value = "prix") int price) {
		System.out.println(price);
		return new Vehicule("DD55FF", "Fiat", price);
	}
	
	/**
	 * utiliser post man ou programmer
	 * @param car
	 */
	
	@DeleteMapping("/voitures")
	public void delete(@RequestBody Vehicule car) {
		System.out.println(car);
	}
	
}
