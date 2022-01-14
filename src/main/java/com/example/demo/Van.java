package com.example.demo;

import javax.persistence.Entity;

@Entity
public class Van extends Vehicule {
    private float poidsMax;

    public Van(String plaque, String marque, float prix, float poids) {
        super(plaque, marque, prix);
        poidsMax = poids;
    }

    public float getPoidsMax() {
        return poidsMax;
    }

    public void setPoidsMax(float poidsMax) {
        this.poidsMax = poidsMax;
    }
}
