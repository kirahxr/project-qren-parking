package com.parkingtry.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.parkingtry.model.Transaksi;
import com.parkingtry.service.TransaksiService;

@RestController
@Controller
@CrossOrigin("*")
public class TransaksiController {

	
	@Autowired
	TransaksiService trs;
	
	@GetMapping("/transaksi-count/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id){
		HashMap<String, Long> tar;
		try {
			tar = trs.getB(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.ok(tar);
		
	}
	
	@GetMapping(value = "/transaksi-report-merchant",params = {"merchant"})
	public ResponseEntity<?> findByReport(String merchant){
		List<Transaksi> tar;
		try {
			tar = trs.getReport(merchant);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.ok(tar);
		
	}
	
	@GetMapping(value = "/transaksi-report",params = {"start","end","merchant"})
	public ResponseEntity<?> findByReport(String start,String end,String merchant){
		List<Transaksi> tar;
		try {
			tar = trs.getReport(start, end,merchant);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.ok(tar);
		
	}
	
	
	
	
}
