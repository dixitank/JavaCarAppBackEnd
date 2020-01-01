package com.rhkdhv.springboot.car.rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.rhkdhv.springboot.car.rest.dto.CarDTO;
import com.rhkdhv.springboot.car.rest.entity.Car;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CarRepository carRepository;

	@Test
	public void whenFindCarsByYearOrBrand_thenReturnCar() {
		// given
		Car car = new Car();
		car.setModel("Focus");
		car.setBrand("Ford");
		car.setVersion("2.0 GLX");
		car.setYearOfRelease(2019);
		car.setPrice("18000");
		car.setFuelConsumption(Double.valueOf("11"));
		car.setAnnualMaintenanceCost(Double.valueOf("6000"));
		entityManager.persist(car);
		entityManager.flush();

		// when
		List<CarDTO> cars = carRepository.findCarsByYearOrBrand(2019, "Ford");

		// then
		assertThat(cars.get(0).getBrand()).isEqualTo(car.getBrand());
	}
}
