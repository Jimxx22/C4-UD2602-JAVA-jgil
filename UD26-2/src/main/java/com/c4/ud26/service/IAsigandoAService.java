package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.AsignadoA;

public interface IAsigandoAService {

	public List<AsignadoA> listarAsigandosA();
	
	public AsignadoA guardarAsigandoA(AsignadoA asignadoA);
	
	public AsignadoA asignadoAXID (Long id);
	
	public AsignadoA actualitzarAsigandoA(AsignadoA asignadoA);
	
	public void eliminarAsigandoA(Long id);
}
