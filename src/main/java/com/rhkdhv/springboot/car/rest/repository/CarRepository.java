package com.rhkdhv.springboot.car.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rhkdhv.springboot.car.rest.dto.CarDTO;
import com.rhkdhv.springboot.car.rest.entity.Car;

/**
 * 
 * CarRepository class
 *
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	@Query("SELECT new com.rhkdhv.springboot.car.rest.dto.CarDTO(c.id, c.model, c.brand, c.version, c.yearOfRelease, c.price, c.fuelConsumption, c.annualMaintenanceCost) FROM Car c where (:yearOfRelease  is null or c.yearOfRelease = :yearOfRelease) and (:brand is null or c.brand = :brand)")
	List<CarDTO> findCarsByYearOrBrand(@Param("yearOfRelease") Integer yearOfRelease, @Param("brand") String brand);

}
