package com.casestudy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name="model_id", referencedColumnName="model_id", nullable=true)
	Model model;

	Integer year;

	@Column(name = "color")
	String color;

	@Column(name = "vin")
	Integer vin;

	@Column(name = "miles")
	Double miles;

}
