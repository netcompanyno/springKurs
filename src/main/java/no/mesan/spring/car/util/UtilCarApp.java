package no.mesan.spring.car.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static no.mesan.utils.ClassUtils.pathToClass;

/** Hello world! */
public class UtilCarApp {

    private static final String SPRING_CONFIG=
        pathToClass(UtilCarApp.class) + "UtilCar.spring.xml";

    public static void main(final String[] args) {
        final BeanFactory ctx= new ClassPathXmlApplicationContext(SPRING_CONFIG);
        final Car car1= ctx.getBean("car", Car.class);
        final Car car2= ctx.getBean("oldCar", Car.class);
        car1.getEngine().setCylinders(6);
        car2.setFourWd(true);
        System.out.println(car1);
        System.out.println(car2);
    }
}
