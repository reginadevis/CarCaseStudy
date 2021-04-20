package com.casestudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "model")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long modelId;
	
	@Column(name = "model")
	String model;

}
