package com.happn.techtest.service;

import java.util.List;

import com.happn.techtest.entities.Zone;
/**
 * 
 * @author zack
 *
 */
public interface IZoneService {
    /**
     * 
     * @return
     */
	List<Zone> findAll();
    /**
     * 
     * @param density
     * @return
     */
	List<Zone> findBydensity(int density);

}