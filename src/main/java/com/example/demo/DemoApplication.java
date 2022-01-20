package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.Entity.Location;
import com.example.demo.Entity.Personne;
import com.example.demo.Entity.Van;
import com.example.demo.Entity.Voiture;
import com.example.demo.Repository.LocationRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(LocationRepository locationRepository) {
		return (args) -> {
			Personne moi = new Personne(1, "Nabil", "Kajeiou");

			Voiture merco = new Voiture("11AA22", "Mercedes Classe B", 1200, 5);
			Van van = new Van("EL777QA", "Renault", 3000, 3000);

			moi.setVehicule(merco);

			Location loc = new Location(0,"25/11/2021","26/11/2021");
			Collection<Location>locations = new ArrayList<Location>();
			locations.add(loc);

			Location loc2 = new Location(1, "07/01/2022","08/01/2022" );
			
			locations.add(loc2);

			loc.louer(moi, merco);
			loc2.louer(moi,van);
			merco.setLocations(locations);
			moi.setLocations(locations);

			locationRepository.save(loc);
		};
	}

}
