package com.casestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.casestudy.dto.CarDto;
import com.casestudy.entity.Car;
import com.casestudy.exception.CarNotFoundException;
import com.casestudy.mapper.CarMapper;
import com.casestudy.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	CarRepository carRepository;

	public List<CarDto> getAllCars() {
		List<CarDto> carDtos = CarMapper.INSTANCE.carListtoCarDtoList(carRepository.findAll());
		return carDtos;
	}

	public CarDto getCar(Long id) {
		Car car = null;
		try {
			car = carRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CarNotFoundException(e.getMessage());
		}
		return CarMapper.INSTANCE.carToCarDto(car);
	}

	public void deleteCar(Long id) {
		try {
			carRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CarNotFoundException(e.getMessage());
		}
	}

	public CarDto mergeCar(CarDto carDto) {
		CarDto carUpdate = null;
		try {
			Car car = CarMapper.INSTANCE.carDtotoCar(carDto);
			Car updatedCar = carRepository.save(car);
			carUpdate = CarMapper.INSTANCE.carToCarDto(updatedCar);
		} catch (DataIntegrityViolationException exception) {
			if (exception.getLocalizedMessage().contains("ConstraintViolationException")
					&& exception.getLocalizedMessage().contains("vin")) {
				throw new CarNotFoundException("Vehicle already present");
			}
			throw new CarNotFoundException(exception.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CarNotFoundException(e.getMessage());
		}
		return carUpdate;
	}
}
