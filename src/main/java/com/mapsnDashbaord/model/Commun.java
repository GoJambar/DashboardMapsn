package com.mapsnDashbaord.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity

public class Commun {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String codeCom;
	private String name;
	private double superficie;
	private double population, latitude, longitude;
	private String detail;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Arrondissement codeAr;

	public Commun() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commun(String codeCom, String name, double superficie, double population, double latitude, double longitute,
			String detail, Arrondissement codeAr) {
		super();
		this.codeCom = codeCom;
		this.name = name;
		this.superficie = superficie;
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitute;
		this.detail = detail;
		this.codeAr = codeAr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeCom() {
		return codeCom;
	}

	public void setCodeCom(String codeCom) {
		this.codeCom = codeCom;
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

	public void setLongitute(double longitute) {
		this.longitude = longitude;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Arrondissement getCodeAr() {
		return codeAr;
	}

	public void setCodeAr(Arrondissement codeAr) {
		this.codeAr = codeAr;
	}

}
