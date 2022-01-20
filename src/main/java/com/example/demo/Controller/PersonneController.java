package com.example.demo.Controller;

import com.example.demo.Entity.Personne;
import com.example.demo.Repository.PersonneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneController {
    PersonneRepository personneRepository;

    @Autowired
    public PersonneController(PersonneRepository personneRepository) {
        this.personneRepository=personneRepository;
    }

    @GetMapping(value="/personnes")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Personne> listePersonnes() {
        return personneRepository.findAll();
    }

    @GetMapping("/personnes/{identifiant}")
	public Personne getPersonne(@PathVariable(value = "identifiant") int identifiant){
        return personneRepository.findById(identifiant).get();
	}
}
