package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.Repository.LocationRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(LocationRepository locationRepository) {
		return (args) -> {
			Voiture seat = new Voiture("11AA22", "Seat Leon", 1200, 5);
			Van van = new Van("EL777QA", "Mercedes", 3000, 3000);

			Personne moi = new Personne(1, "Nabil", "Kajeiou");
			moi.setVehicule(seat);

			Location loc = new Location(0,"25/11/2021","26/11/2021");
			Collection<Location>locations = new ArrayList<Location>();
			locations.add(loc);

			Location loc2 = new Location(1, "07/01/2022","08/01/2022" );

			locations.add(loc2);

			loc.louer(moi, seat);
			loc2.louer(moi,van);

			seat.setLocations(locations);
			moi.setLocations(locations);

			locationRepository.save(loc);
		};
	}

}
