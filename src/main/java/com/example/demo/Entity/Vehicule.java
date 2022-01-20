package com.example.demo.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

@Entity
@DiscriminatorColumn(name="TypeVehicule",discriminatorType=DiscriminatorType.STRING)
public class Vehicule {
	
	private String plaque;
	private String marque;
	private float prix;
	private boolean louable;
	private Collection<Location>locations;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="vehiculeLouee")
	public Collection<Location> getLocations() {
		return locations;
	}

	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}

	public Vehicule() {
		plaque = null;
		marque = "Non assigné";
		prix = 0;
		louable = false;

	}
	
	public Vehicule(String plaque, String marque, float prix) {
		this.plaque = plaque;
		this.marque = marque;
		this.prix = prix;
        this.louable = false;

	}
	@Id
	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public float getPrix() {
		return prix;
	}
	
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public boolean getLocation() {
		return this.louable;
	}
	public void setLocation(boolean rent) {
		this.louable = rent;
	}

	@Override
	public String toString() {
		return "Car{" +
				"plateNumber='" + plaque + '\'' +
				", brand='" + marque + '\'' +
				", price=" + prix +
				", rent=" + louable +
				'}';
	}
}
