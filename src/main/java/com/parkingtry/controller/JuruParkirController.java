package com.parkingtry.controller;

import java.util.HashMap;
import java.util.List;

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

import com.parkingtry.model.JuruParkir;
import com.parkingtry.service.JuruParkirService;

@RestController
@Controller
@CrossOrigin("*")
public class JuruParkirController {
	
	
	@Autowired
	JuruParkirService jurs;

	@PostMapping("/JuruParkir")
	public ResponseEntity<?> saveTarif(@RequestBody JuruParkir JuruParkir){
		
		try {
			
			jurs.saveJuruParkir(JuruParkir);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Insert JuruParkir Failed"+e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Insert JuruParkir Succes");
		
	}
	
	@PostMapping("/JuruParkir-list")
	public ResponseEntity<?> saveTarif(@RequestBody List<JuruParkir> JuruParkir){
		
		try {
			
			for(JuruParkir b :JuruParkir) {
				jurs.saveJuruParkir(b);
			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Insert JuruParkir Failed"+e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Insert JuruParkir Succes");
		
	}
	
	@GetMapping(value ="JuruParkir", params = { "merchant","page", "limit" })
	public ResponseEntity<?> getAllMerchant(String merchant,int page,int limit){
		List<JuruParkir> list;
		Long count;
		HashMap<String,Object> lists = new HashMap<String,Object>();
		try {
			
			list = jurs.getAllMerchant(merchant, page, limit);
			count = jurs.count(merchant);
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Get Data Failed"+e);
			// TODO: handle exception
			
		}
		lists.put("data", list);
		lists.put("count", count);
		return ResponseEntity.ok(lists);
	}
	
	@GetMapping("/JuruParkir")
	public ResponseEntity<?> getAll(){
		List<JuruParkir> list;
		try {
			list = jurs.getAll();
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Get Data Failed"+e);
			// TODO: handle exception
		}
		return ResponseEntity.ok(list);
	}
	
	
	
	@GetMapping("/JuruParkir/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		JuruParkir list;
		try {
			list = jurs.findById(id);
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Get Data Failed"+e);
			// TODO: handle exception
		}
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/JuruParkir/{id}")
	public ResponseEntity<?> Update(@RequestBody JuruParkir jp,@PathVariable("id") Long id){
		JuruParkir list;
		try {
			list = jurs.findById(id);
			list.setEmail(jp.getEmail());
			list.setMerchantApiKey(jp.getMerchantApiKey());
			list.setNama(jp.getNama());
			list.setPassword(jp.getPassword());
			list.setToken(jp.getToken());
			jurs.updateJuruParkir(list);
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Update Failed"+e);
			// TODO: handle exception
		}
		return ResponseEntity.ok("Update Succes");
	}
	
	@DeleteMapping("/JuruParkir/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		try {
			jurs.delete(id);
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body(e);
			// TODO: handle exception
		}
		return ResponseEntity.ok("Delete Success");
	}
	
	
}
