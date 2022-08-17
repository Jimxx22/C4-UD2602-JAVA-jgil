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

import com.c4.ud26.dto.Cientifico;
import com.c4.ud26.service.CientificoServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificoController {

	@Autowired
	CientificoServiceImpl cientificoServiceImpl;
	
	@GetMapping("/cientificos")
	public List<Cientifico> listarCientificos(){
		return cientificoServiceImpl.listarCientificos();
	}
	
	@PostMapping("/cientificos")
	public Cientifico guardarCientifico(@RequestBody Cientifico cientifico) {
		return cientificoServiceImpl.guardarCientifico(cientifico);
	}
	
	@GetMapping("/cientificos/{dni}")
	public Cientifico cientificoXID(@PathVariable(name="dni") String id) {
		return cientificoServiceImpl.cientificoXID(id);
	}
	
	@PutMapping("/cientificos/{dni}")
	public Cientifico actualizarCientifico(@PathVariable(name="dni") String id, @RequestBody Cientifico cientifico) {
		Cientifico cientificoSel= new Cientifico();
		Cientifico cientificoAct= new Cientifico();
		
		cientificoSel=cientificoServiceImpl.cientificoXID(id);
		
		cientificoSel.setNombre_apels(cientifico.getNombre_apels());
		
		cientificoAct= cientificoServiceImpl.actulizarCientifico(cientificoSel);
		
		return cientificoAct;
		
	}
	
	@DeleteMapping("/cientificos/{dni}")
	public String eliminarCientifico(@PathVariable(name="dni") String id) {
		try {
			cientificoServiceImpl.eliminarCientifico(id);
			return "Cientifico eliminada";
		}catch (Exception e) {
			return "Error: no puedes borrar esta cientifico ya que tiene proyectos asignados";
		}
		
	}
}
