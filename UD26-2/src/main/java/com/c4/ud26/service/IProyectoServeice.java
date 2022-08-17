package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Proyecto;

public interface IProyectoServeice {
	
	public List<Proyecto> listarProyectos();
	
	public Proyecto guardarProyecto(Proyecto proyecto);
	
	public Proyecto proyectoXID(String id);
	
	public Proyecto actualizarProyecto(Proyecto proyecto);
	
	public void eliminarProyecto(String id);

}
