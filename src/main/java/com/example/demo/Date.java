package com.example.demo;

import javax.persistence.Entity;

public class Date {
    String dateDebut;
    String dateFin;

    public Date(String dateDebut, String dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Date{" +
                "dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                '}';
    }
}
