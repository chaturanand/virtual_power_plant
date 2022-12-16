package com.java.proshore.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.java.proshore.model.Batteries;
import com.java.proshore.repository.BatteriesRepository;
import com.java.proshore.services.BatteriesService;
import com.java.proshore.services.BatteriesServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BatteriesServiceTest {

	@Mock
	private BatteriesRepository batteriesRepository;

	@InjectMocks
	private BatteriesServiceImpl batteriesServiceImpl;

	@Test
	void shouldSavedBatteriesSuccessFully() {
		final Batteries batteries = new Batteries(1L, "Cannington", "6107", 13500);

		given(batteriesRepository.save(batteries)).willAnswer(invocation -> invocation.getArgument(0));

		Batteries saveBattery = batteriesServiceImpl.createBatteries(batteries);

		assertThat(saveBattery).isNotNull();

		verify(batteriesRepository).save(batteries);
	}

	@Test
	void shouldReturnFindAll() {
		List<Batteries> batteries = new ArrayList();
		batteries.add(new Batteries(1L, "Cannington", "6107", 13500));
		batteries.add(new Batteries(2L, "Midland", "6057", 50500));
		batteries.add(new Batteries(3L, "Hay Street", "6000", 23500));

		given(batteriesRepository.findAll()).willReturn(batteries);

		List<Batteries> expected = batteriesRepository.findAll();

		assertEquals(expected, batteries);
	}

}
