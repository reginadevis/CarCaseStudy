package com.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.entity.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}