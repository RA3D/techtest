package com.happn.techtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happn.techtest.entities.InterestPoints;
import com.happn.techtest.entities.Zone;
import com.happn.techtest.repository.IInterstPointRpository;

@Service
public class ZoneService implements IZoneService {

	private static final double HALF = 0.5;
	@Autowired
	IInterstPointRpository interestPointsRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.happn.techtest.service.IZoneService#findAll()
	 */
	@Override
	public List<Zone> findAll() {
		List<Zone> zoneList = new ArrayList<>();
		List<InterestPoints> ipos = interestPointsRepository.findAll();
		ipos.stream().forEach(ipo -> {
			Zone zone = getZoneByPois(ipo);
			zoneList.add(zone);
		});
		return zoneList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.happn.techtest.service.IZoneService#findBydensity(int)
	 */
	@Override
	public List<Zone> findBydensity(int density) {
		List<Zone> zoneList = findAll();
		Map<Zone, Long> counts = zoneList.stream().collect(Collectors.groupingBy(z -> z, Collectors.counting()));

		return counts.entrySet().stream().filter(c -> c.getValue() >= density).map(f -> f.getKey())
				.collect(Collectors.toList());

	}

	private Zone getZoneByPois(InterestPoints ipo) {
		Pair<Double, Double> latitudePair = getNumberRange(ipo.getLatitude());
		double minLat = latitudePair.getLeft();
		double maxLat = latitudePair.getRight();

		Pair<Double, Double> longitudePair = getNumberRange(ipo.getLongitude());
		double minLon = longitudePair.getLeft();
		double maxLon = longitudePair.getRight();

		return new Zone(minLat, maxLat, minLon, maxLon);

	}

	// private method to calculate range for a given Latitude/Longitude
	// each zone is a grid of 0.5°, every point belong to a specific zone
	// e.g: interestPoint (-48.6,-37.6) belong to Zone [(-48.6,-37.5),(-49.0,-38.0)]
	private Pair<Double, Double> getNumberRange(double d) {

		double min;
		double max;
		double roundedValue = Math.round(d * 2) / 2.0;
		if (roundedValue > d) {
			min = roundedValue - HALF;
			max = roundedValue;
		} else {
			min = roundedValue;
			max = roundedValue + HALF;
		}

		return Pair.of(min, max);
	}

}
