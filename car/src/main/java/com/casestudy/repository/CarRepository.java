package com.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
