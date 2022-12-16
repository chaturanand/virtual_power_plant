package com.java.proshore.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.proshore.model.Batteries;
import com.java.proshore.repository.BatteriesRepository;
import com.java.proshore.services.BatteriesService;

@WebMvcTest(controllers = BatteriesController.class)
@ActiveProfiles("test")
public class BatteriesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BatteriesService batteriesService;
	
	@MockBean
	private BatteriesRepository batteriesRepository;

	@Autowired(required=true)
	private ObjectMapper objectMapper;

	private List<Batteries> batteriesList;
	
	private List<String> statisticData;

	@Before
	public void setUp() {
		this.batteriesList = new ArrayList<>();
		this.batteriesList.add(new Batteries(1L, "Cannington", "6107", 13500));
		this.batteriesList.add(new Batteries(2L, "Midland", "6057", 50500));
		this.batteriesList.add(new Batteries(3L, "Hay Street", "6000", 23500));

		objectMapper.registerModule(new ProblemModule());
		objectMapper.registerModule(new ConstraintViolationProblemModule());
	}
	
	@Test
    void shouldFetchAllBatteries() throws Exception {

        given(batteriesRepository.findAll()).willReturn(batteriesList);

        this.mockMvc.perform(get("/api/v1/batteries"))
                .andExpect(status().isOk());
                
    }

	@Test
	public void shouldsaveBattery() throws Exception {

		given(batteriesService.createBatteries(any(Batteries.class)))
				.willAnswer((invocation) -> invocation.getArgument(0));

		Batteries batteries = new Batteries(1L, "Cannington", "6107", 13500);

		this.mockMvc
				.perform(post("/api/v1/batteries").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(batteries)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.name", is(batteries.getName())))
				.andExpect(jsonPath("$.postcode", is(batteries.getPostcode())))
				.andExpect(jsonPath("$.capacity", is(batteries.getCapacity())));

	}
	
	
	

}
