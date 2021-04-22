package com.casestudy.validator;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.casestudy.dto.ModelDto;
import com.casestudy.entity.Manufacturer;
import com.casestudy.entity.Model;
import com.casestudy.repository.ManufacturerRepository;
import com.casestudy.repository.ModelRepository;

public class CarModelValidator implements ConstraintValidator<ValidCarModel, ModelDto> {
	@Autowired
	Validator validator;

	@Autowired
	ModelRepository modelRepository;

	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Override
	public boolean isValid(ModelDto modelDto, ConstraintValidatorContext constraintValidatorContext) {

		boolean isValid = false;
		Model dbModel = null;
		Manufacturer manufacturer = null;

		System.out.println("Validator invoked");

		try {
			dbModel = modelRepository.getById(modelDto.getModel_id());

			manufacturer = manufacturerRepository.getById(modelDto.getManufacturer().getManufacturer_id());

			System.out.println(dbModel);
		} catch (EntityNotFoundException e) {
			System.out.println("Entity not found");
			isValid = false;
			return isValid;
		}

		if (!dbModel.getManufacturer().equals(manufacturer)) {
			System.out.println("Is not valid");
			isValid = true;
		}

		System.out.println("isValid " + isValid);
		return isValid;
	}

}
