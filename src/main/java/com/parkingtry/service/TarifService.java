package com.parkingtry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingtry.dao.TarifDao;
import com.parkingtry.model.Tarif;


@Service
public class TarifService {
	
	
	@Autowired
	TarifDao tarDao;
	
	
	
	public void insertModel(Tarif tarif) {
		
		tarDao.saveTarif(tarif);
	}
	
	public Tarif findById(Long id) {
		return tarDao.findById(id);
	}
	
	public void updateTarif(Tarif tar) {
		tarDao.saveTarif(tar);
	}
	
	
	public List<Tarif> getAll(){
		return tarDao.getAll();
	}
	
	public void delete(Long id) throws Exception {
		try {
			tarDao.deleteTarif(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Delete Gagal");
		}
	}

}
