package com.java.proshore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.proshore.model.Batteries;
import com.java.proshore.repository.BatteriesRepository;
import com.java.proshore.services.BatteriesService;

/**
 * 
 * @author chaturanand yadav
 *
 */
@RestController
@RequestMapping("/api/v1")
public class BatteriesController {
	
	@Autowired
	private BatteriesRepository batteriesRepository;

	@Autowired
	private BatteriesService batteriesService;

	@GetMapping("/batteries")
	public List<Batteries> getAllBatteries() {
		/*
		 * find the all the data of the Sorting By Name
		 */
		return batteriesRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	@GetMapping("/batteries/statistics")
	public String getStaticData() {
		List<String> statisticData = new ArrayList<String>();
		statisticData.add("The Sum And Average of Watt Capacity are:");
		statisticData.addAll(batteriesRepository.countStatistics());
		String jsonStr = JSONArray.toJSONString(statisticData);
		return jsonStr;

	}

	@PostMapping("/batteries")
	public ResponseEntity<Batteries> saveBattery(@RequestBody @Valid Batteries batteries) {

		try {
			Batteries _batteries = batteriesService.createBatteries(batteries);
			return new ResponseEntity<>(_batteries, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
