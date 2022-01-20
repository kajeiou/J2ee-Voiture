package com.example.demo.Repository;

import com.example.demo.Entity.Personne;

import org.springframework.data.repository.CrudRepository;

public interface PersonneRepository extends CrudRepository<Personne, Integer> {

}
