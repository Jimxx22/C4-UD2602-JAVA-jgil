package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Cientifico;

public interface ICientificoService {

	public List<Cientifico> listarCientificos();
	
	public Cientifico guardarCientifico(Cientifico cientifico);
	
	public Cientifico cientificoXID(String id);
	
	public Cientifico actulizarCientifico(Cientifico cientifico);
	
	public void eliminarCientifico(String id);
}
