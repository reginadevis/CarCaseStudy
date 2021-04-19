package com.casestudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="car")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="manufacturer")
	String manufacturer;
	
	@Column(name="model")
	String model;
	
	@Column(name="year")
	Integer year;
	
	@Column(name="color")
	String color;
	
	@Column(name="vin")
	Integer vin;
	
	@Column(name="miles")
	Double miles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getVin() {
		return vin;
	}

	public void setVin(Integer vin) {
		this.vin = vin;
	}

	public Double getMiles() {
		return miles;
	}

	public void setMiles(Double miles) {
		this.miles = miles;
	}

	

}
