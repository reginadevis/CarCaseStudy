package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;

public class VinValidator implements ConstraintValidator<ValidVin, Integer> {

    @Autowired
    Validator validator;

    @Override
    public boolean isValid(Integer vin, ConstraintValidatorContext constraintValidatorContext) {

        boolean isValid = true;

        if(Integer.parseInt(Integer.toString(vin).substring(0, 1)) == 2){
            isValid = false;
        }
        return isValid;
    }
}
