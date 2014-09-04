package no.mesan.spring.car.xml;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;



/** Test CarApp. */
@Ignore
@ContextConfiguration("Car.spring.xml")
public class CarAppTest extends AbstractJUnit4SpringContextTests {

    /** Test object 1. */
    private Car car;
    /** Test object 2. */
    private Car oldCar;

    @Before
    public void setUp() {
        this.car= this.applicationContext.getBean("car", Car.class);
        this.oldCar= this.applicationContext.getBean("oldCar", Car.class);
    }

    @Test
    public void car1withEngine() {
        assertEquals("VW", this.car.getMake());
        assertEquals(2010, this.car.getYear());
        assertEquals(4, this.car.getEngine().getCylinders());
    }

    @Test
    public void car2withEngine() throws Exception {
        assertEquals("VW", this.oldCar.getMake());
        assertTrue(this.car.getYear() > this.oldCar.getYear());
        assertEquals(4, this.car.getEngine().getCylinders());
        assertNotSame(this.oldCar, this.car);
    }
}
