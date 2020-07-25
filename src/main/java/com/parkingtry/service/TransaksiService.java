package com.parkingtry.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingtry.dao.TransaksiDao;
import com.parkingtry.model.Transaksi;

@Service
public class TransaksiService {

	@Autowired
	TransaksiDao trDao;
	
	public HashMap<String,Long> getB(String meString) {
		return trDao.getCountKendaraan(meString);
	}
	
	
	public List<Transaksi> getReport(String start,String end,String merchant) {
		
		return trDao.getReport(start, end,merchant);
	}
	
	public List<Transaksi> getReport(String merchant) {
		
		return trDao.getReportByMechant(merchant);

	}
	
}
