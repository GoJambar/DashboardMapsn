package com.mapsnDashbaord.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Departement {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String codeDep;
	private String name;
	private double superficie;
	private double population, latitude, longitude;
	private String detail;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Region codeRegion;

	@OneToMany(mappedBy = "codeDep", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Collection<Arrondissement> arron = new ArrayList<>();

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(String codeDep, String name, double superficie, double population, double latitude,
			double longitude, String detail, Region codeRegion, Collection<Arrondissement> arron) {
		super();
		this.codeDep = codeDep;
		this.name = name;
		this.superficie = superficie;
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitude;
		this.detail = detail;
		this.codeRegion = codeRegion;
		this.arron = arron;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeDep() {
		return codeDep;
	}

	public void setCodeDep(String codeDep) {
		this.codeDep = codeDep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Region getCodeRegion() {
		return codeRegion;
	}

	public void setCodeRegion(Region codeRegion) {
		this.codeRegion = codeRegion;
	}

	public Collection<Arrondissement> getArron() {
		return arron;
	}

	public void setArron(Collection<Arrondissement> arron) {
		this.arron = arron;
	}

}