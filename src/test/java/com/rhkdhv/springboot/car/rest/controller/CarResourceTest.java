package com.rhkdhv.springboot.car.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rhkdhv.springboot.car.rest.dto.CarDTO;
import com.rhkdhv.springboot.car.rest.service.CarService;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(CarResource.class)
public class CarResourceTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CarService service;

	@Test
	public void givenCars_whenGetCars_thenReturnJsonArray() throws Exception {

		CarDTO car = new CarDTO(Long.valueOf("1"), "Focus", "Ford", "2.0 GLX", Integer.valueOf(2019),
				"18000", Double.valueOf("11"), Double.valueOf("6000"));
		List<CarDTO> cars = new ArrayList<>();
		cars.add(car);

		when(service.findCarsByYearOrBrand(2019, "Ford")).thenReturn(cars);

		mvc.perform(get("/cars").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
