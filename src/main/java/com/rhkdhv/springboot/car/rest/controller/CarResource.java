package com.rhkdhv.springboot.car.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rhkdhv.springboot.car.rest.dto.CarDTO;
import com.rhkdhv.springboot.car.rest.entity.Car;
import com.rhkdhv.springboot.car.rest.exception.CarNotFoundException;
import com.rhkdhv.springboot.car.rest.service.CarService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class CarResource {

	@Autowired
	private CarService carService;
    
	/**
	 * This method will add a new car details in the database 
	 * @param car
	 * @return ResponseEntity
	 * @throws CarNotFoundException
	 */
	@PostMapping("/cars")
	public ResponseEntity<Object> addCar(@RequestBody Car car) throws CarNotFoundException {
		Car newCar = carService.saveCar(car);
		if (null == newCar) {
			return ResponseEntity.notFound().build();
		} else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCar.getId())
					.toUri();

			return ResponseEntity.created(location).build();
		}

	}

	/**
	 * This method will retrieve the car by id from the database
	 * @param id
	 * @return Car
	 */
	@GetMapping("/cars/{id}")
	public Car retrieveCar(@PathVariable long id) {
		Optional<Car> car = carService.findById(id);
		if (!car.isPresent())
			throw new CarNotFoundException("id-" + id);

		return car.get();
	}

	/**
	 * This method will return the list of cars by comparing them based on distance to travel and fuel cost
	 * @param distanceToTravel
	 * @param fuelPricePerLitre
	 * @return
	 * @throws CarNotFoundException
	 */
	@GetMapping("/cars/{distanceToTravel}/{fuelPricePerLitre}")
	public ResponseEntity<Object>  retrieveCarsByMaintenanceCost(@PathVariable Integer distanceToTravel,
			@PathVariable Double fuelPricePerLitre) throws CarNotFoundException {
		List<Car> carsList = carService.findCardsByMaintenanceCost(distanceToTravel, fuelPricePerLitre);
		if (null == carsList) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<Object>(carsList, HttpStatus.OK);

	}
	
	/**
	 * This method will retrieve the cars based on brand and year of release if passed , else will return the list of all cars 
	 * @param yearOfRelease
	 * @param brand
	 * @return
	 * @throws CarNotFoundException
	 */
	@GetMapping("/cars")
	public ResponseEntity<Object> retrieveCarsByyearOrBrand(@RequestParam(required = false) Integer yearOfRelease,
			@RequestParam(required = false) String brand) throws CarNotFoundException {
		if (StringUtils.isEmpty(brand)) {
			brand = null;
		}
		List<CarDTO> cars = carService.findCarsByYearOrBrand(yearOfRelease, brand);
		if (null == cars) {
			return ResponseEntity.notFound().build();
		}
			
		return new ResponseEntity<Object>(cars, HttpStatus.OK);
	}

}
