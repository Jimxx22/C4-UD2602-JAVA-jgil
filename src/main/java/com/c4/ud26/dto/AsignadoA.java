package com.c4.ud26.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="asignado_a")
public class AsignadoA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="dni_cientifico")
	private Cientifico dni_cientifico;
	
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto id_proyecto;

	public AsignadoA(Cientifico dni_cientifico, Proyecto id_proyecto) {
		this.dni_cientifico = dni_cientifico;
		this.id_proyecto = id_proyecto;
	}

	public AsignadoA() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cientifico getDni_cientifico() {
		return dni_cientifico;
	}

	public void setDni_cientifico(Cientifico dni_cientifico) {
		this.dni_cientifico = dni_cientifico;
	}

	public Proyecto getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(Proyecto id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	@Override
	public String toString() {
		return "AsignadoA [id=" + id + ", dni_cientifico=" + dni_cientifico + ", id_proyecto=" + id_proyecto + "]";
	}
}
