package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CarRentalService {
	
	private List<Vehicule> cars = new ArrayList<Vehicule>();
	
	public CarRentalService() {
		cars.add(new Vehicule("11AA22", "Ferrari", 1000));
		cars.add(new Vehicule("33BB44", "Porshe", 2222));
	}
	
	@GetMapping("/cars")
	public List<Vehicule> getListOfCars(){
		return cars;
	}
	
	@PostMapping("/cars")
	public void addCar(@RequestBody Vehicule car) throws Exception{
		System.out.println(car);
		cars.add(car);
	}

	@GetMapping("/cars/{plateNumber}")
	public Vehicule getCar(@PathVariable(value = "plateNumber") String plateNumber){
		for(Vehicule car: cars){
			if(car.getPlaque().equals(plateNumber)){
				return car;
			}
		}
		return null;
	}

	@PutMapping("/cars/{plateNumber}")

	public void rent(@PathVariable(value = "plateNumber") String plateNumber, @RequestParam(value="rent") boolean rent, @RequestBody Date date){
		System.out.println(date);

		Vehicule car = this.getCar(plateNumber);
		if(car!=null) {
			car.setLocation(rent);
			System.out.println(car);
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune voiture de cette plaque");


	}

}
