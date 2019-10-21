package com.happn.techtest.repository;

import java.util.List;
import java.util.Optional;

import com.happn.techtest.entities.InterestPoints;
/**
 * 
 * @author zack
 *
 */
public interface IInterstPointRpository {
    /**
     * 
     * @return
     */
	List<InterestPoints> findAll();
    /**
     * 
     * @param id
     * @return
     */
	Optional<InterestPoints> getOne(String id);

}