package com.mapsnDashbaord.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Region {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = false,updatable = true)
	private String codeRegion;
	private String name;
	private String photo;
	private double superficie;
	private double population, latitude, longitude;
	private String detail;

	@OneToMany(mappedBy = "codeRegion", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Collection<Departement> depart = new ArrayList<>();

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Region(String codeRegion, String name, String photo, double superficie, double population, double latitude,
			double longitude, String detail, Collection<Departement> depart) {
		super();
		this.codeRegion = codeRegion;
		this.name = name;
		this.photo = photo;
		this.superficie = superficie;
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitude;
		this.detail = detail;
		this.depart = depart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeRegion() {
		return codeRegion;
	}

	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Collection<Departement> getDepart() {
		return depart;
	}

	public void setDepart(Collection<Departement> depart) {
		this.depart = depart;
	}

}
