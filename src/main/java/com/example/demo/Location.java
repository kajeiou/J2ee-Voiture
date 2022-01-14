package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Location {
    private int idLocation;
    private Date dateDebut;
    private Date dateFin;
    private Vehicule vehiculeLouee;
    private Personne conducteur;


    public Location(int idLocation, String dateDebut, String dateFin) {
        this.idLocation = idLocation;

          
        this.dateDebut = this.convertirDate(dateDebut);
        this.dateFin = this.convertirDate(dateFin);

    }
    public Date convertirDate(String date) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date nouvelledate;
        try {
            nouvelledate = simpleDateFormat.parse(date);
            return nouvelledate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = convertirDate(dateDebut);
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = convertirDate(dateFin);
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
