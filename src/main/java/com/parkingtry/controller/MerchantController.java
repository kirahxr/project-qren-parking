package com.parkingtry.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parkingtry.model.Merchant;
import com.parkingtry.service.MerchantService;

@Controller
@RestController
@CrossOrigin("*")
public class MerchantController {
	
	@Autowired
	MerchantService merService;

	@PostMapping("/merchant")
	public ResponseEntity<?> saveTarif(@RequestBody Merchant merchant){
		
		try {
			
			merService.saveMerChant(merchant);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Insert Mechant Failed");

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Insert Merchant Succes");
		
	}
	
	
	@PostMapping("/merchant-list")
	public ResponseEntity<?> saveTarif(@RequestBody List<Merchant> merchant){
		
		try {
			
			for(Merchant b : merchant) {
				merService.saveMerChant(b);
			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Insert Mechant Failed");

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Insert Merchant Succes");
		
	}

	
	@PostMapping("/login-merchant")
	public ResponseEntity<?> login(@RequestBody Map<String,String> merchant){
		HashMap<String, Object> data = new HashMap<String, Object>();
		Merchant datas = new Merchant();
		try {
			 
			datas = merService.login(merchant.get("username"), merchant.get("password"));
			datas.setToken(merService.generateNewToken());
			merService.updateMerChant(datas);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);

			// TODO: handle exception
		}
		data.put("user",datas);
		data.put("message", "Login Sukses");
		return ResponseEntity.ok(data);
		
	}
	
	@PostMapping("/update-password/{id}")
	public ResponseEntity<?> updatePassword(@PathVariable("id") String id,@RequestBody HashMap<String,String> merchant){

		try {
			 
			merService.changePassword(id, merchant);
		
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Update Password Sukses");
		
	}
	
	
	
	
	
	
	
	
	@GetMapping("/merchant/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id){
		Merchant mer = new Merchant();
		try {
			mer = merService.findById(id);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok(mer);
		
	}
	
	@DeleteMapping("/merchant/{id}")
	public ResponseEntity<?> deleteMapping(@PathVariable("id") String id){
		try {
			merService.delete(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Delete Succes");
		
	}
	@GetMapping("/merchant")
	public ResponseEntity<?> getAll(){
		List<Merchant> mer;
		try {
			mer = merService.getAll();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok(mer);
		
	}
	
	
	@PutMapping("/merchant/{id}")
	public ResponseEntity<?> Update(@RequestBody Merchant mers,@PathVariable("id") String id){
		Merchant mer = new Merchant();
		try {
			mer = merService.findById(id);
			mer.setMerchantApiKey(mers.getMerchantApiKey());
			mer.setnama(mers.getnama());
			mer.setPassword(mers.getPassword());
			mer.setToken(mers.getToken());
			merService.updateMerChant(mer);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Update Succes");
		
	}
	
	
	
}
