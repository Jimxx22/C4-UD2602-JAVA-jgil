package com.c4.ud26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4.ud26.dto.Proyecto;
import com.c4.ud26.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired 
	ProyectoServiceImpl proyectoServiceImpl;
	
	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectos(){
		return proyectoServiceImpl.listarProyectos();
	}
	
	@PostMapping("/proyectos")
	public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto proyectoXID(@PathVariable(name="id") String id) {
		
		Proyecto proyectoXID = new Proyecto();
		
		proyectoXID=proyectoServiceImpl.proyectoXID(id);
		
		return proyectoXID;
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id") String id, @RequestBody Proyecto proyecto) {
		
		Proyecto proyectoSel = new Proyecto();
		Proyecto proyectoAct = new Proyecto();
		
		proyectoSel=proyectoServiceImpl.proyectoXID(id);
		
		proyectoSel.setNombre(proyecto.getNombre());
		proyectoSel.setHoras(proyecto.getHoras());
		
		proyectoAct=proyectoServiceImpl.actualizarProyecto(proyectoSel);
		
		return proyectoAct;
	}
	
	@DeleteMapping("/proyectos/{id}")
	public String eliminarProyecto(@PathVariable(name="id") String id) {
		try {
			proyectoServiceImpl.eliminarProyecto(id);
			return "Proyecto eliminado";
		}catch (Exception e) {
			return "Error: no puedes borrar este proyecto ya que tiene ealgun cientifico asigando a este";
		}
	}
}
