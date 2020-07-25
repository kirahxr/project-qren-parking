package com.parkingtry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.parkingtry.model.Tarif;
import com.parkingtry.service.TarifService;

@RestController
@Controller
@CrossOrigin("*")
public class TarifController {

	@Autowired
	TarifService tarifService;
	
	@PostMapping("/tarif")
	public ResponseEntity<?> saveTarif(@RequestBody Tarif tarif){
		
		try {
			
			tarifService.insertModel(tarif);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Insert Tarif Failed");

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Insert Tarif Succes");
		
	}
	
	
	@PostMapping("/tarif-list")
	public ResponseEntity<?> saveTarif(@RequestBody List<Tarif> tarif){
		
		try {
			for(Tarif b :tarif) {
				tarifService.insertModel(b);
			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Insert Tarif Failed");

			// TODO: handle exception
		}
		
		return ResponseEntity.ok("Insert Tarif Succes");
		
	}
	
	
	
	@GetMapping("/tarif/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		Tarif tar = new Tarif();
		try {
			 tar =tarifService.findById(id);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.ok(tar);
		
	}
	
	@DeleteMapping("/tarif/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		try {
			 tarifService.delete(id);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.ok("Delete Succes");
		
	}
	
	@GetMapping("/tarif")
	public ResponseEntity<?> findById(){
		List<Tarif> tar;
		try {
			 tar =tarifService.getAll();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.ok(tar);
		
	}
	
	@PutMapping("/tarif/{id}")
	public ResponseEntity<?> update(@RequestBody Tarif tarif,@PathVariable("id") Long id){
		Tarif tar = new Tarif();
		try {
			 tar =tarifService.findById(id);
			 tar.setMobil(tarif.getMobil());
			 tar.setMotor(tarif.getMotor());
			 tar.setTruk(tarif.getTruk());
			 tar.setNoTicket(tarif.getNoTicket());
			 tarifService.updateTarif(tar);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.ok("Update Berhasil");
		
	}
	
	
}
