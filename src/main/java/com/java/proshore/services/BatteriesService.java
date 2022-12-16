package com.java.proshore.services;

import java.util.List;

import com.java.proshore.model.Batteries;
/**
 * 
 * @author chaturanand yadav
 *
 */
public interface BatteriesService {
	Batteries createBatteries(Batteries batteries);
	List<String> countStatistics();
}
