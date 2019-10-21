package com.happn.techtest.service;

import java.util.List;

import com.happn.techtest.entities.InterestPoints;
/**
 * 
 * @author zack
 *
 */
public interface IInterestPointService {
    /**
     * 
     * @return
     */
	List<InterestPoints> findAll();
    /**
     * 
     * @param minLat
     * @param minLon
     * @return
     */
	List<InterestPoints> findInterestPointInZone(double minLat, double minLon);
    /**
     * 
     * @param minLat
     * @param minLon
     * @return
     */
	int countInterestPointInZone(double minLat, double minLon);

}