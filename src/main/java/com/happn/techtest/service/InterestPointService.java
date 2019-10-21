package com.happn.techtest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happn.techtest.entities.InterestPoints;
import com.happn.techtest.repository.IInterstPointRpository;

@Service
public class InterestPointService implements IInterestPointService {
	@Autowired
	IInterstPointRpository interstPointRepository;

	@Override
	public List<InterestPoints> findAll() {
		return interstPointRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.happn.techtest.service.IInterestPointService#findZoneOfInterestPoint(
	 * double, double)
	 */
	@Override
	public List<InterestPoints> findInterestPointInZone(double minLat, double minLon) {
		List<InterestPoints> ipos = interstPointRepository.findAll();
		return ipos.stream().filter(p -> p.getLatitude() > minLat && p.getLongitude() > minLon)
				.collect(Collectors.toList());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.happn.techtest.service.IInterestPointService#
	 * findCountOfInterestPointInZone(double, double)
	 */
	@Override
	public int countInterestPointInZone(double minLat, double minLon) {
		return findInterestPointInZone(minLat, minLon).size();
	}

}
