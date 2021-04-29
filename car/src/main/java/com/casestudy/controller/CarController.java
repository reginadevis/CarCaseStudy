package com.casestudy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.casestudy.dto.CarDto;
import com.casestudy.service.CarService;

@RestController
public class CarController {

	@Autowired
	CarService carService;

	@GetMapping("/cars")
	private List<CarDto> getAllCars() {
		List<CarDto> cars = carService.getAllCars();
		return cars;
	}

	@GetMapping("/car/{id}")
	private CarDto getCar(@PathVariable("id") Long id) {
		CarDto car = carService.getCar(id);
		System.out.println("Getting into the real carController");
		if (ObjectUtils.isEmpty(car)) {
			System.out.println("Car is empty");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "car.notpresent");
		}
		return car;
	}

	@DeleteMapping("/car/{id}")
	private void deleteCar(@PathVariable("id") Long id) {
		carService.deleteCar(id);
	}

	@PostMapping("/car")
	private CarDto saveCar(@Valid @RequestBody CarDto carDto) {
		System.out.println("Controoler : carDto :" + carDto.getModel().getManufacturer().getManufacturer_id());
		return carService.mergeCar(carDto);
	}

	@PutMapping("/car")
	private CarDto updateCar(@Valid @RequestBody CarDto carDto) {
		return carService.mergeCar(carDto);
	}
}
