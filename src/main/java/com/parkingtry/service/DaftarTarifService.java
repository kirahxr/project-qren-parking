package com.parkingtry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingtry.dao.DaftarTarifDao;
import com.parkingtry.model.DaftarTarif;

@Service
public class DaftarTarifService {

	@Autowired
	DaftarTarifDao daftarServiceDao;
	
	@Autowired 
	MerchantService mers;
	
	@Autowired
	TarifService dafs;
	
	public void saveDaftarTarif(DaftarTarif daftarTarif) {
		System.out.println(daftarTarif.getIdTarif().getIdTarif());
		daftarTarif.setIdTarif(dafs.findById(daftarTarif.getIdTarif().getIdTarif()));
		daftarTarif.setMerchantApiKey(mers.findById(daftarTarif.getMerchantApiKey().getMerchantApiKey()));
		daftarServiceDao.saveDaftarTarif(daftarTarif);
	}
	
	
	public DaftarTarif findById(Long id) {
		return daftarServiceDao.findById(id);
	}
	
	public void updateDaftarTarif(DaftarTarif daftarTarif) {
		daftarTarif.setIdTarif(dafs.findById(daftarTarif.getIdTarif().getIdTarif()));
		daftarTarif.setMerchantApiKey(mers.findById(daftarTarif.getMerchantApiKey().getMerchantApiKey()));
		daftarServiceDao.saveDaftarTarif(daftarTarif);
	}
	
	public List<DaftarTarif> getAll(){
		return daftarServiceDao.getAll();
	}
	
	public DaftarTarif getByMerchant(String id){
		return daftarServiceDao.getAllMerchant(id);
	}
	
	public void delete(Long id) throws Exception {
		try {
			daftarServiceDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Delete Gagal");
		}
	}
	
}
