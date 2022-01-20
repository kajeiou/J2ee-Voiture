package com.example.demo.Repository;

import com.example.demo.Entity.Location;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Integer> {

}
