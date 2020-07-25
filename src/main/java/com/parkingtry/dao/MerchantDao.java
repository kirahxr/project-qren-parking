package com.parkingtry.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.parkingtry.model.Merchant;

@Repository("merchant")
@Transactional
public class MerchantDao extends CommonDao {

	@Transactional
	public Merchant saveMerchant(Merchant merchant) {
		return super.entityManager.merge(merchant);
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public Merchant findById(String id) {
		List<Merchant> lstTarif = super.entityManager.createQuery(""+
				"FROM Merchant where merchantApiKey=:idtarif").setParameter("idtarif", id).getResultList();
		if(lstTarif.size() == 0) {
			return new Merchant();
		}
		else {
			return lstTarif.get(0);
		}
		
	}
	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public Merchant login(String user,String password) {
		List<Merchant> lstTarif = super.entityManager.createQuery(""+
				"FROM Merchant where email=:email and password=:password").setParameter("password",password).setParameter("email", user).getResultList();
		if(lstTarif.size() == 0) {
			return new Merchant();
		}
		else {
			return lstTarif.get(0);
		}
		
	}
	
	@Transactional
	public void delete(String id) throws Exception {
		Merchant mer = findById(id);
		if(mer.getMerchantApiKey()!= null) {
			super.entityManager.remove(mer);

		}
		else {
			throw new Exception("Delete Gagal");
		}
	}
	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Merchant> getAll() {
		List<Merchant> lstTarif = super.entityManager.createQuery(""+
				"FROM Merchant ").getResultList();
		if(lstTarif.size() == 0) {
			return lstTarif;
		}
		else {
			return lstTarif;
		}
		
	}
	
	
	
}
