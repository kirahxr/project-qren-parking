package com.parkingtry.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingtry.dao.MerchantDao;
import com.parkingtry.model.Merchant;

@Service
public class MerchantService {
	
	@Autowired
	MerchantDao merDao;

	public void saveMerChant(Merchant merchant) {
		merDao.saveMerchant(merchant);
	}
	
	
	private  final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private  final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

	public  String generateNewToken() {
	    byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}
	
	public Merchant findById(String id) {
		return merDao.findById(id);
	}
	
	public void changePassword(String id,HashMap<String, String> old) throws Exception {
		Merchant oldData = merDao.findById(id);
		if(oldData.getPassword().equals(old.get("oldPassword"))) {
			oldData.setPassword(old.get("newPassword"));
			try {
				
				merDao.saveMerchant(oldData);
				
			} catch (Exception e) {
					throw new Exception("Execution Failed");
			}
		}
		else {
			throw new Exception("Password Did Not Macth");
		}
	}
	
	public void updateMerChant(Merchant merchant) {
		merDao.saveMerchant(merchant);
	}
	
	public List<Merchant> getAll(){
		return merDao.getAll();
	}
	
	public Merchant login(String id,String password) throws Exception {
		Merchant mer = merDao.login(id, password);
		if(mer.getEmail()!= null) {
			return merDao.login(id, password);
		}
		else {
			throw new Exception("Username atau Email Salah");
		}
		
	}
	
	public void delete(String id) throws Exception {
		try {
			merDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Delete Gagal");
		}
	}
	
}
