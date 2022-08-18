package com.c4.ud26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4.ud26.dao.IAsignadoADAO;
import com.c4.ud26.dto.AsignadoA;
@Service
public class AsigandoAServiceImpl implements IAsigandoAService{
	
	@Autowired
	IAsignadoADAO iAsigandoADAO;

	@Override
	public List<AsignadoA> listarAsigandosA() {
		// TODO Auto-generated method stub
		return iAsigandoADAO.findAll();
	}

	@Override
	public AsignadoA guardarAsigandoA(AsignadoA asignadoA) {
		// TODO Auto-generated method stub
		return iAsigandoADAO.save(asignadoA);
	}

	@Override
	public AsignadoA asignadoAXID(Long id) {
		// TODO Auto-generated method stub
		return iAsigandoADAO.findById(id).get();
	}

	@Override
	public AsignadoA actualitzarAsigandoA(AsignadoA asignadoA) {
		// TODO Auto-generated method stub
		return iAsigandoADAO.save(asignadoA);
	}

	@Override
	public void eliminarAsigandoA(Long id) {
		// TODO Auto-generated method stub
		iAsigandoADAO.deleteById(id);
	}

}
