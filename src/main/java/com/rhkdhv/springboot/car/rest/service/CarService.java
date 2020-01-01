package com.rhkdhv.springboot.car.rest.service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhkdhv.springboot.car.rest.dto.CarDTO;
import com.rhkdhv.springboot.car.rest.entity.Car;
import com.rhkdhv.springboot.car.rest.repository.CarRepository;

/**
 * 
 * CarService class 
 *
 */
@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
    
	/**
	 * Saves the car in database
	 * @param car
	 * @return car
	 */
	public Car saveCar(Car car) {
		NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
		try {
			car.setPrice(format.parse(car.getPrice().replace(".", ",")).toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carRepository.saveAndFlush(car);
	}
    
	/**
	 * Find car by id
	 * @param id
	 * @return optional car 
	 */
	public Optional<Car> findById(long id) {
		return carRepository.findById(id);
	}

	/**
	 * Finds all cars 
	 * @return car list 
	 */
	public List<Car> findAll() {
		return carRepository.findAll();
	}
    
	/**
	 * Finds and returns CarDTO based on year of release and brand passed, else return all cars 
	 * @param yearOfRelease
	 * @param brand
	 * @return
	 */
	public List<CarDTO> findCarsByYearOrBrand(Integer yearOfRelease, String brand) {
		return carRepository.findCarsByYearOrBrand(yearOfRelease, brand);
	}
    
	/**
	 * This method will return the list of cars by comparing them based on distance to travel and fuel cost
	 * @param distanceToTravel
	 * @param fuelPricePerLitre
	 * @return
	 */
	public List<Car> findCardsByMaintenanceCost(Integer distanceToTravel, Double fuelPricePerLitre) {
		List<Car> carsList = carRepository.findAll();
		carsList.sort((Car c1, Car c2) -> c1.getMaintenanceCost(distanceToTravel, fuelPricePerLitre)
				.compareTo(c2.getMaintenanceCost(distanceToTravel, fuelPricePerLitre)));
		return carsList;

	}
}
