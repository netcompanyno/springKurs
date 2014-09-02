package no.mesan.spring.hellocar;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static no.mesan.utils.Strings.isEmpty;

/** Car OK? */
@Component
public class CarValidator implements Validator {


    @Override
    public boolean supports(final Class<?> clazz) {
        return Car.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(final Object target, final Errors errors) {
        final Car car= (Car) target;
        if ( isEmpty(car.getMake()) ) {
            errors.reject("car.missing.make", car + ": " + "Car.make is missing");
        }
        if ( isEmpty(car.getModel()) ) {
            errors.reject("car.missing.model", car + ": " + "Car.model is missing");
        }
        final int year= car.getYear();
        if ( (year < 0) || (year > 0 && year < 1900)  ) {
            errors.reject("car.invalid.year", car + ": " + "Car.year is invalid");
        }
        final int doors= car.getDoors();
        if ( (doors < 0) || (doors > 10)  ) {
            errors.reject("car.invalid.doors", car + ": " + "Car.doors is invalid");
        }
        if ( car.getEngine()==null ) {
            errors.reject("car.missing.engine", car + ": " + "Car has no engine");
        }
    }
}
