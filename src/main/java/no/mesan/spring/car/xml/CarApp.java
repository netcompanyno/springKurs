package no.mesan.spring.car.xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static no.mesan.utils.ClassUtils.pathToClass;

/** Hello world! */
public class CarApp {

    private static final String SPRING_CONFIG=
        pathToClass(CarApp.class) + "Car.spring.xml";

    public static void main(final String[] args) {
        final BeanFactory ctx= new ClassPathXmlApplicationContext(SPRING_CONFIG);
        Car car= ctx.getBean("car", Car.class);
        System.out.println(car);
        car= ctx.getBean("oldCar", Car.class);
        System.out.println(car);
    }
}
