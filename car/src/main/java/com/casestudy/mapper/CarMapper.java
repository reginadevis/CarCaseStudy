package com.casestudy.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.casestudy.dto.CarDto;
import com.casestudy.entity.Car;

@Mapper
public interface CarMapper {
	
	CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
	
	CarDto carToCarDto(Car car);
	
	Car carDtotoCar(CarDto carDto);
	
	List<CarDto> carListtoCarDtoList(List<Car> cars);

}