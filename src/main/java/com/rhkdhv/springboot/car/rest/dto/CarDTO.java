package com.rhkdhv.springboot.car.rest.dto;

/**
 * 
 * This class is a data transfer object class for Car entity which gets the data from entity and returns the data back to the requester. 
 *
 */
public class CarDTO {
	private Long id;
	private String model;
	private String brand;
	private String version;
	private Integer yearOfRelease;
	private String price;
	private Double fuelConsumption;
	private Double annualMaintenanceCost;
	
	public CarDTO(Long id, String model, String brand, String version, Integer yearOfRelease, String price, Double fuelConsumption, Double annualMaintenanceCost) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.version = version;
		this.yearOfRelease = yearOfRelease;
		this.price = price;
		this.fuelConsumption = fuelConsumption;
		this.annualMaintenanceCost = annualMaintenanceCost;
	}
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
