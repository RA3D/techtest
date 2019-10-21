package com.happn.techtest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.happn.techtest.entities.InterestPoints;

@Repository
public class InterstPointRepository implements IInterstPointRpository {
	@Autowired
    @Qualifier("loadTSVFile")
    private List<InterestPoints> load;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.happn.techtest.repository.IInterstPointRpository#findAll()
	 */
	@Override
	public List<InterestPoints> findAll() {
		return load;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.happn.techtest.repository.IInterstPointRpository#getOne(java.lang.String)
	 */
	@Override
	public Optional<InterestPoints> getOne(String id) {
		return load.stream().filter(i -> i.getId().equals(id)).findAny();
	}

}
