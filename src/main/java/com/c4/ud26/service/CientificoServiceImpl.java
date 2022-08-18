package com.c4.ud26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4.ud26.dao.ICientificoDAO;
import com.c4.ud26.dto.Cientifico;

@Service
public class CientificoServiceImpl implements ICientificoService{
	
	@Autowired
	ICientificoDAO iCientificoDAO;

	@Override
	public List<Cientifico> listarCientificos() {
		// TODO Auto-generated method stub
		return iCientificoDAO.findAll();
	}

	@Override
	public Cientifico guardarCientifico(Cientifico cientifico) {
		// TODO Auto-generated method stub
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public Cientifico cientificoXID(String id) {
		// TODO Auto-generated method stub
		return iCientificoDAO.findById(id).get();
	}

	@Override
	public Cientifico actulizarCientifico(Cientifico cientifico) {
		// TODO Auto-generated method stub
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public void eliminarCientifico(String id) {
		iCientificoDAO.deleteById(id);	
	}

}
