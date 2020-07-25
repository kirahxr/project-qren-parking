package com.parkingtry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingtry.dao.JuruParkirDao;
import com.parkingtry.model.JuruParkir;

@Service
public class JuruParkirService {
	
	@Autowired
	MerchantService mer;
	
	@Autowired
	JuruParkirDao jurDao;
	
	public void saveJuruParkir(JuruParkir JuruParkir) {
		JuruParkir.setMerchantApiKey(mer.findById(JuruParkir.getMerchantApiKey().getMerchantApiKey()));
		JuruParkir.setToken(this.mer.generateNewToken());
		jurDao.saveJuruParkir(JuruParkir);
	}
	
	
	public JuruParkir findById(Long id) {
		return jurDao.findById(id);
	}
	
	public void updateJuruParkir(JuruParkir JuruParkir) {
		JuruParkir.setMerchantApiKey(mer.findById(JuruParkir.getMerchantApiKey().getMerchantApiKey()));
		jurDao.saveJuruParkir(JuruParkir);
	}
	
	public Long count(String merchant) {
		
		return jurDao.getCunt(merchant);
	}
	
	public List<JuruParkir> getAll(){
		return jurDao.getAll();
	}
	
	public List<JuruParkir> getAllMerchant(String merchant,int page,int limit){
		return jurDao.getAllMerchant(merchant, page, limit);
	}
	
	public void delete(Long id) throws Exception {
		try {
			jurDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Delete Gagal");
		}
	}

}
