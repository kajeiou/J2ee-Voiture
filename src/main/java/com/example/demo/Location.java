package com.example.demo;

import javax.persistence.*;

@Entity
public class Location {
    private int idLocation;
    private String dateDebut;
    private String dateFin;
    private Vehicule vehiculeLouee;
    private Personne conducteur;


    public Location(int idLocation, String dateDebut, String dateFin) {
        this.idLocation = idLocation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;

    }
    public void louer(Personne p, Vehicule v) {
        this.setConducteur(p);
        this.setVehiculeLouee(v);
    }
    public Location() {
        idLocation = 0;
        dateDebut = null;
        dateFin = null;
        vehiculeLouee = null;
        conducteur = null;

    }
    @Id
    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
    @ManyToOne(cascade=CascadeType.ALL)
    public Vehicule getVehiculeLouee() {
        return vehiculeLouee;
    }

    public void setVehiculeLouee(Vehicule vehiculeLouee) {
        this.vehiculeLouee = vehiculeLouee;
    }
    @ManyToOne(cascade=CascadeType.ALL)
    public Personne getConducteur() {
        return conducteur;
    }

    public void setConducteur(Personne conducteur) {
        this.conducteur = conducteur;
    }
}
