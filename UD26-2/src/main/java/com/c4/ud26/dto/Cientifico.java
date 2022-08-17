package com.c4.ud26.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cientificos")
public class Cientifico {

	@Id
	@Column(name="dni")
	private String dni;
	
	@Column(name="nombre_apels")
	private String nombre_apels;
	
	@OneToMany
	@JoinColumn(name="dni_cientifico")
	private List<AsignadoA> asignadosA;

	public Cientifico() {
	}

	public Cientifico(String dni, String nombre_apels) {
		this.dni = dni;
		this.nombre_apels = nombre_apels;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre_apels() {
		return nombre_apels;
	}

	public void setNombre_apels(String nombre_apels) {
		this.nombre_apels = nombre_apels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AsignadoA")
	public List<AsignadoA> getAsignadosA() {
		return asignadosA;
	}

	public void setAsignadosA(List<AsignadoA> asignadosA) {
		this.asignadosA = asignadosA;
	}

	@Override
	public String toString() {
		return "Cientifico [dni=" + dni + ", nombre_apels=" + nombre_apels + ", asignadosA=" + asignadosA + "]";
	}

}
