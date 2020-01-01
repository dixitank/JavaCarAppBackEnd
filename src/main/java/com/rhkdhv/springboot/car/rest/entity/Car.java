package com.rhkdhv.springboot.car.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String model;
	private String brand;
	private String version;
	private Integer yearOfRelease;
	private String price;
	private Double fuelConsumption;
	private Double annualMaintenanceCost;
	
	private static final Integer TIME_DURATION = 12 * 4; 

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

	public Double getMaintenanceCost(Integer kiloMetersToTravelPerMonth,
			Double fuelPricePerLitre) {
		Integer totalDistanceToBeTravelled = kiloMetersToTravelPerMonth * TIME_DURATION;
		Double totalFuelToBeConsumed = totalDistanceToBeTravelled / this.getFuelConsumption();
		Double totalFuelCost = totalFuelToBeConsumed * fuelPricePerLitre;
		return totalFuelCost + Double.parseDouble(this.getPrice()) + this.getAnnualMaintenanceCost();

	}

}
