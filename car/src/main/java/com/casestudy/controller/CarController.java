package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.entity.Car;
import com.casestudy.repository.CarRepository;

@RestController
public class CarController {

	@Autowired
	CarRepository carRepository;
	
	@GetMapping()
	private List<Car> getAllCars(){
		return carRepository.findAll();
	}
	
	@GetMapping("/car/{id}")
	private Car getCar(@PathVariable("id")Long id) {
		Car car = carRepository.findById(id).get();
		return car;
	}
	
	@DeleteMapping("/car/{id}")
	private void deleteCar(@PathVariable("id")Long id) {
		carRepository.deleteById(id);
	}
	
	@PostMapping("/car")
	private void saveCar(@RequestBody Car car) {
		carRepository.save(car);
		
	}
	
	@PutMapping("/car")
	private Car updateCar(@RequestBody Car car) {
		carRepository.save(car);
		return car;
	}
}