package com.happn.techtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.happn.techtest.entities.Zone;
import com.happn.techtest.service.IZoneService;

@RestController
@RequestMapping("/api/v0")
public class ZoneController {
	
	@Autowired
	IZoneService service;

	@RequestMapping("/zones")
	public List<Zone> findAllZones() {
		return service.findAll();
	}
	
	@RequestMapping("/zones/density")
	public List<Zone> findDenseZones(@RequestParam(value = "value", defaultValue = "2") int density) {
		return service.findBydensity(density);
	}
	
	

}
