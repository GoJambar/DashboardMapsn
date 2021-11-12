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
public class Arrondissement {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String codeAr;
	private String name;
	private double superficie;
	private double population, latitude, longitude;
	private String detail;
	// private int codeAr;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Departement codeDep;
	@OneToMany(mappedBy = "codeAr", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Collection<Commun> commun = new ArrayList<>();

	public Arrondissement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arrondissement(String codeAr, String name, double superficie, double population, double latitude,
			double longitude, String detail, Departement codeDep, Collection<Commun> commun) {
		super();
		this.codeAr = codeAr;
		this.name = name;
		this.superficie = superficie;
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitude;
		this.detail = detail;
		this.codeDep = codeDep;
		this.commun = commun;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeAr() {
		return codeAr;
	}

	public void setCodeAr(String codeAr) {
		this.codeAr = codeAr;
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

	public Departement getCodeDep() {
		return codeDep;
	}

	public void setCodeDep(Departement codeDep) {
		this.codeDep = codeDep;
	}

	public Collection<Commun> getCommun() {
		return commun;
	}

	public void setCommun(Collection<Commun> commun) {
		this.commun = commun;
	}

}
