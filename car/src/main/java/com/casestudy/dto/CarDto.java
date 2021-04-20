package com.casestudy.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

	Long ID;
	
	String manufacturer;
	
	String model;
	
	Integer year;
	
	String color;
	
	Integer vin;
	
	Double miles;

}
