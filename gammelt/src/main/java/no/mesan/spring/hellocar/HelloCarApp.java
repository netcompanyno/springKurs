package no.mesan.spring.hellocar;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static no.mesan.utils.ClassUtils.pathToClass;

/** Hello world! */
public class HelloCarApp {

    private static final String SPRING_CONFIG=
        pathToClass(HelloCarApp.class) + "HelloCar.spring.xml";

    public static void main(final String[] args) {
        final BeanFactory ctx= new ClassPathXmlApplicationContext(SPRING_CONFIG);
        final Car car1= ctx.getBean("car1", Car.class);
        final Car car2= ctx.getBean("car2", Car.class);
        final Greeter greeter= (Greeter) ctx.getBean("greeter");
        final String greet1= greeter.greet(car1.toString());
        final String greet2= greeter.greet(car2.toString());
        System.out.println(greet1);
        System.out.println(greet2);
        final Validator validator= ctx.getBean(Validator.class);
        final Set<ConstraintViolation<Car>> validate= validator.validate(car1);
        validate.addAll(validator.validate(car2));
        for (final ConstraintViolation<Car> bad: validate) {
            System.err.println(bad.getPropertyPath() + " " +  bad.getMessage());
        }
    }
}
