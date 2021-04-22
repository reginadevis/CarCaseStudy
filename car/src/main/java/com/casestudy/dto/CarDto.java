package com.casestudy.dto;

import com.casestudy.validator.ValidCarModel;

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

	@ValidCarModel
	ModelDto model;

	Integer year;

	String color;

	Integer vin;

	Double miles;

}
