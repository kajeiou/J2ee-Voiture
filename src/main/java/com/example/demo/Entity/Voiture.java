package com.example.demo.Entity;

import javax.persistence.Entity;

import com.example.demo.Entity.Vehicule;

@Entity
public class Voiture extends Vehicule{
    private int nombreDeSieges;

    public Voiture(String plaque, String marque, float prix, int nbSieges) {
        super(plaque, marque, prix);
        nombreDeSieges = nbSieges;
    }

    public Voiture() {
        super();
        this.nombreDeSieges =0;
    }

    public int getNombreDeSieges() {
        return nombreDeSieges;
    }

    public void setNombreDeSieges(int nombreDeSieges) {
        this.nombreDeSieges = nombreDeSieges;
    }
}
