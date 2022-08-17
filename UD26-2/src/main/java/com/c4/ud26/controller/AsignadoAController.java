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

import com.c4.ud26.dto.AsignadoA;
import com.c4.ud26.service.AsigandoAServiceImpl;

@RestController
@RequestMapping("/api")
public class AsignadoAController {
	
	@Autowired 
	AsigandoAServiceImpl asignadoAServiceImpl;
	
	@GetMapping("/asignados")
	public List<AsignadoA> listarAsigandosA(){
		return asignadoAServiceImpl.listarAsigandosA();
	}
	
	@PostMapping("/asignados")
	public AsignadoA guardarAsigandoA(@RequestBody AsignadoA asignadoA) {
		return asignadoAServiceImpl.guardarAsigandoA(asignadoA);
	}
	
	@GetMapping("/asignados/{id}")
	public AsignadoA asignadoAXID(@PathVariable(name="id") Long id) {
		
		AsignadoA asignadoAXID = new AsignadoA();
		
		asignadoAXID=asignadoAServiceImpl.asignadoAXID(id);
		
		return asignadoAXID;
	}

	@PutMapping("/asignados/{id}")
	public AsignadoA actualizarAsigandoA(@PathVariable(name="id") Long id, @RequestBody AsignadoA asignadoA) {
		
		AsignadoA asignadoASel = new AsignadoA();
		AsignadoA asignadoAAct = new AsignadoA();
		
		asignadoASel=asignadoAServiceImpl.asignadoAXID(id);
		
		asignadoASel.setDni_cientifico(asignadoA.getDni_cientifico());
		asignadoASel.setId_proyecto(asignadoA.getId_proyecto());
		
		asignadoAAct = asignadoAServiceImpl.actualitzarAsigandoA(asignadoASel);
		
		return asignadoAAct;		
	}
	
	@DeleteMapping("/asignados/{id}")
	public void eliminsarAsigandoA(@PathVariable(name="id") Long id) {
		asignadoAServiceImpl.eliminarAsigandoA(id);
	}
}
