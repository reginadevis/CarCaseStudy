package com.casestudy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.casestudy.entity.Car;


public interface CarRepository extends JpaRepository<Car, Long>{



}
