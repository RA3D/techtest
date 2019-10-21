package com.happn.techtest.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.happn.techtest.entities.InterestPoints;
import com.happn.techtest.service.IInterestPointService;

@RestController
@RequestMapping("/api/v0")
public class InterestPointsController {

	@Autowired
	IInterestPointService service;

	@RequestMapping("/points/all")
	public List<InterestPoints> findAll() {

		return service.findAll();

	}

	@RequestMapping("/points")
	public List<InterestPoints> findZoneOfInterestPoint(
			@RequestParam(value = "minLat", defaultValue = "2") double minLat,
			@RequestParam(value = "minLon", defaultValue = "2") double minLon) {

		return service.findInterestPointInZone(minLat, minLon);

	}

	@RequestMapping("/points/count")
	public Map<String, Integer> findCountOfInterestPointInZone(
			@RequestParam(value = "minLat", defaultValue = "2") double minLat,
			@RequestParam(value = "minLon", defaultValue = "2") double minLon) {

		int count = service.countInterestPointInZone(minLat, minLon);
		return Collections.singletonMap("value", count);

	}

}
