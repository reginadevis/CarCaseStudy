package com.casestudy.service;

import com.casestudy.dto.CarDto;
import com.casestudy.entity.Car;
import com.casestudy.mapper.CarMapper;
import com.casestudy.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

	@Autowired
	CarRepository carRepository;

	public List<CarDto> getAllCars() {
		List<CarDto> carDtos = CarMapper.INSTANCE.carListtoCarDtoList(carRepository.findAll());
		if (carDtos != null && !carDtos.isEmpty()){}
		else{throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "common.error");}
		return carDtos;
	}

	public CarDto getCar(Long id) {
		Car car = null;
		try {
			car = carRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "car.notpresent");
		}
		return CarMapper.INSTANCE.carToCarDto(car);
	}

	public void deleteCar(Long id) {
		try {
			carRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "car.notpresent", e);
		}
	}

	public CarDto mergeCar(CarDto carDto) {
		CarDto carUpdate = null;
		try {
			Car car = CarMapper.INSTANCE.carDtotoCar(carDto);
			Car updatedCar = carRepository.save(car);
			carUpdate = CarMapper.INSTANCE.carToCarDto(updatedCar);
		} catch (DataIntegrityViolationException ex) {
			ex.printStackTrace();
			if (ex.getMessage().contains("vin"))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "vin.present", ex);

		} catch (Exception exception) {
			exception.printStackTrace();
			if (exception.getMessage().contains("model"))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "model.issue", exception);
			if (exception.getMessage().contains("manufacturer"))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "manufacturer.issue", exception);

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "common.error", exception);
		}
		if(carUpdate == null)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "common.error", new RuntimeException());
		}
		return carUpdate;
	}
}
