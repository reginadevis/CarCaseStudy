package com.casestudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "car")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ID;

	@OneToOne(mappedBy = "car")
	Manufacturer manufacturer;

	@OneToOne(mappedBy = "car")
	Model model;

	@Column(name = "year")
	Integer year;

	@Column(name = "color")
	String color;

	@Column(name = "vin")
	Integer vin;

	@Column(name = "miles")
	Double miles;

}
