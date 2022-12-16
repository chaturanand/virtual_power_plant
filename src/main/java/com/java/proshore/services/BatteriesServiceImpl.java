package com.java.proshore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.proshore.model.Batteries;
import com.java.proshore.repository.BatteriesRepository;

/**
 * 
 * @author chaturanand yadav
 *
 */
@Service
public class BatteriesServiceImpl implements BatteriesService {

	@Autowired
	private BatteriesRepository batteriesRepository;
	
	@Autowired
    public BatteriesServiceImpl(BatteriesRepository batteriesRepository) {
        this.batteriesRepository = batteriesRepository;
    }

	@Override
	public Batteries createBatteries(Batteries batteries) {
		return batteriesRepository.save(batteries);
	}

	@Override
	public List<String> countStatistics() {

		return batteriesRepository.countStatistics();
	}

	

}
