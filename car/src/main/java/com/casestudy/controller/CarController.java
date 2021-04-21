package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.CarDto;
import com.casestudy.exception.CarNotFoundException;
import com.casestudy.service.CarService;

@RestController
public class CarController {

	@Autowired
	CarService carService;

	@GetMapping("/cars")
	private List<CarDto> getAllCars() {
		List<CarDto> cars = carService.getAllCars();
		if (cars.isEmpty())
			throw new CarNotFoundException("No cars in database");
		return cars;
	}

	@GetMapping("/car/{id}")
	private CarDto getCar(@PathVariable("id") Long id) {
		CarDto car = carService.getCar(id);
		if (ObjectUtils.isEmpty(car)) {
			throw new CarNotFoundException("id- " + id);
		}
		return carService.getCar(id);
	}

	@DeleteMapping("/car/{id}")
	private void deleteCar(@PathVariable("id") Long id) {
		carService.deleteCar(id);
	}

	@PostMapping("/car")
	private CarDto saveCar(@RequestBody CarDto carDto) {
		System.out.println("Controoler : carDto :" + carDto.getModel().getManufacturer().getManufacturer_id());
		return carService.mergeCar(carDto);
	}

	@PutMapping("/car")
	private CarDto updateCar(@RequestBody CarDto carDto) {
		return carService.mergeCar(carDto);
	}
}
