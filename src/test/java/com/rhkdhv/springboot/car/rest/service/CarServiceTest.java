package com.rhkdhv.springboot.car.rest.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rhkdhv.springboot.car.rest.dto.CarDTO;
import com.rhkdhv.springboot.car.rest.entity.Car;
import com.rhkdhv.springboot.car.rest.repository.CarRepository;

@RunWith(SpringRunner.class)
public class CarServiceTest {

	@TestConfiguration
	static class CarServiceTestContextConfiguration {

		@Bean
		public CarService carService() {
			return new CarService();
		}
	}

	@Autowired
	private CarService carService;

	@MockBean
	private CarRepository carRepository;

	@Before
	public void setUp() {
		CarDTO car = new CarDTO(Long.valueOf("1"), "Focus", "Ford", "2.0 GLX", Integer.valueOf(2019), "18000",
				Double.valueOf("11"), Double.valueOf("6000"));

		List<CarDTO> lst = new ArrayList<>();
		lst.add(car);

		Car car1 = new Car();
		car1.setModel("Focus");
		car1.setBrand("Ford");
		car1.setVersion("2.0 GLX");
		car1.setYearOfRelease(2019);
		car1.setPrice("18000");
		car1.setFuelConsumption(Double.valueOf("11"));
		car1.setAnnualMaintenanceCost(Double.valueOf("6000"));

		Car car3 = new Car();
		car3.setModel("C3");
		car3.setBrand("Citroen");
		car3.setVersion("1.6");
		car3.setYearOfRelease(2018);
		car3.setPrice("15000");
		car3.setFuelConsumption(Double.valueOf("13"));
		car3.setAnnualMaintenanceCost(Double.valueOf("6000"));
		List<Car> carList = new ArrayList<>();
		carList.add(car1);
		carList.add(car3);

		Mockito.when(carRepository.findCarsByYearOrBrand(2019, "Ford")).thenReturn(lst);
		Mockito.when(carRepository.findAll()).thenReturn(carList);
	}

	@Test
	public void findCarsByYearOrBrand() {
		CarDTO car = new CarDTO(Long.valueOf("1"), "Focus", "Ford", "2.0 GLX", Integer.valueOf(2019), "18000",
				Double.valueOf("11"), Double.valueOf("6000"));
		List<CarDTO> cars = carService.findCarsByYearOrBrand(2019, "Ford");
		assertThat(cars.get(0).getBrand()).isEqualTo(car.getBrand());

	}

	@Test
	public void findCardsByMaintenanceCost() {
		Car car1 = new Car();
		car1.setModel("Focus");
		car1.setBrand("Ford");
		car1.setVersion("2.0 GLX");
		car1.setYearOfRelease(2019);
		car1.setPrice("18000");
		car1.setFuelConsumption(Double.valueOf("11"));
		car1.setAnnualMaintenanceCost(Double.valueOf("6000"));

		Car car3 = new Car();
		car3.setModel("C3");
		car3.setBrand("Citroen");
		car3.setVersion("1.6");
		car3.setYearOfRelease(2018);
		car3.setPrice("15000");
		car3.setFuelConsumption(Double.valueOf("13"));
		car3.setAnnualMaintenanceCost(Double.valueOf("6000"));
		List<Car> sortedCarsList = carService.findCardsByMaintenanceCost(Integer.valueOf(450), Double.valueOf("0.66"));
		assertThat(sortedCarsList.get(0).getPrice()).isEqualTo(car3.getPrice());
		assertThat(sortedCarsList.get(1).getPrice()).isEqualTo(car1.getPrice());
	}
}
