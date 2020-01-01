package com.rhkdhv.springboot.car.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * Entity class
 *
 */
@Entity
@Table(name = "Car")
public class Car {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message = "Please provide a model name")
	private String model;
	
	@NotEmpty(message = "Please provide a brand name")
	private String brand;
	
	@NotEmpty(message = "Please provide version")
	private String version;
	
	@NotNull(message = "Please provide yearOfRelease")
	private Integer yearOfRelease;
	
	@NotEmpty(message = "Please provide price")
	private String price;
	
	@NotNull(message = "Please provide fuelConsumption")
	private Double fuelConsumption;
	
	@NotNull(message = "Please provide annualMaintenanceCost")
	private Double annualMaintenanceCost;

	private static final Integer MONTHS_IN_YEAR = 12;
	private static final Integer TIME_DURATION_IN_YEARS_EXCEPT_FIRST_YEAR = 3;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(Integer yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(Double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public Double getAnnualMaintenanceCost() {
		return annualMaintenanceCost;
	}

	public void setAnnualMaintenanceCost(Double annualMaintenanceCost) {
		this.annualMaintenanceCost = annualMaintenanceCost;
	}

	public Car() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMaintenanceCost(Integer kiloMetersToTravelPerMonth, Double fuelPricePerLitre) {
		Integer totalDistanceToBeTravelled = kiloMetersToTravelPerMonth * MONTHS_IN_YEAR;
		Double totalFuelToBeConsumed = totalDistanceToBeTravelled / this.getFuelConsumption();
		Double totalFuelCost = totalFuelToBeConsumed * fuelPricePerLitre;
		Double costOfFirstYear = totalFuelCost + Double.parseDouble(this.getPrice()) + this.getAnnualMaintenanceCost();
		Double costOfSubsequentYear = costOfFirstYear - Double.parseDouble(this.getPrice());
		return costOfFirstYear + (costOfSubsequentYear * TIME_DURATION_IN_YEARS_EXCEPT_FIRST_YEAR);

	}

}
