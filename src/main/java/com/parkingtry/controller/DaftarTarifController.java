package com.parkingtry.controller;

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

import com.parkingtry.model.DaftarTarif;
import com.parkingtry.service.DaftarTarifService;

@Controller
@RestController
@CrossOrigin("*")
public class DaftarTarifController {
	@Autowired
	DaftarTarifService merService;

	@PostMapping("/daftarTarif")
	public ResponseEntity<?> saveTarif(@RequestBody DaftarTarif daftarTarif){
		
		try {
			
			merService.saveDaftarTarif(daftarTarif);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Insert Daftar Tarif Failed");

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Insert daftarTarif Succes");
		
	}
	
	@PostMapping("/daftarTarif-list")
	public ResponseEntity<?> saveTarif(@RequestBody List<DaftarTarif> daftarTarif){
		
		try {
			for(DaftarTarif b: daftarTarif) {
				merService.saveDaftarTarif(b);

			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Insert Daftar Tarif Failed"+e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Insert daftarTarif Succes");
		
	}
	
	@GetMapping("/daftarTarif")
	public ResponseEntity<?> getAll(){
		
		List<DaftarTarif> dafs;
		try {
			
			dafs = merService.getAll();
			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Get Data Failed");

			// TODO: handle exception
		}
		
		return ResponseEntity.ok(dafs);
		
	}
	
	@GetMapping("/daftarTarif/{id}")
	public ResponseEntity<?> findByID(@PathVariable("id")Long id){
		
		DaftarTarif dafs;
		try {
			
			dafs = merService.findById(id);
			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Get Data Failed"+e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok(dafs);
		
	}
	
	
	@GetMapping("/daftarTarif-merchant/{id}")
	public ResponseEntity<?> findByMerchant(@PathVariable("id")String id){
		
		DaftarTarif dafs;
		try {
			
			dafs = merService.getByMerchant(id);
			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Get Data Failed"+e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok(dafs);
		
	}
	
	@PutMapping("/daftarTarif/{id}")
	public ResponseEntity<?> Update(@RequestBody DaftarTarif dt,@PathVariable("id")Long id){
		
		DaftarTarif dafs;
		try {
			
			dafs = merService.findById(id);
			dafs.setIdTarif(dt.getIdTarif());
			merService.updateDaftarTarif(dafs);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Update Faile"+e);

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Update Success");
		
	}
	
	@DeleteMapping("/daftar-tarif/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		try {
			merService.delete(id);
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("Error"+e);
			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Delete Succes");
	}
	
	

}
