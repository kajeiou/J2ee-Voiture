package com.example.demo.Repository;

import com.example.demo.Entity.Vehicule;

import org.springframework.data.repository.CrudRepository;

public interface VehiculeRepository extends CrudRepository<Vehicule,String> {

}
