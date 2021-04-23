package com.casestudy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "manufacturer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long manufacturer_id;

	@Column(name = "manufacturer")
	String manufacturer;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name = "manufacturer_id", referencedColumnName = "manufacturer_id", insertable = false, updatable = false)
	List<Model> model;

}
