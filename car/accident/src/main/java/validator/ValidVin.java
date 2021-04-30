package validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { VinValidator.class })
@Documented
public @interface ValidVin {
    String message() default "Vin cannot start with 2";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
