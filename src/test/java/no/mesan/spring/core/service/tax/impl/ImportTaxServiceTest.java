package no.mesan.spring.core.service.tax.impl;

import org.junit.Before;
import org.junit.Test;

import no.mesan.spring.core.domain.car.Engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Test {@link ImportTaxService}.
 */
public class ImportTaxServiceTest extends TaxServiceTest {

    private ImportTaxService service= new ImportTaxService();


    @Before
    public void setUp() {
        this.testObj= this.service;
    }

    @Test
    public void basicStructure() {
        assertEquals(4, this.testObj.calculateTax(this.car).elements.size());
    }

    @Test
    public void basicStructureNoEngine() {
        this.car.setEngine(null);
        assertEquals(3, this.testObj.calculateTax(this.car).elements.size());
    }

    @Test
    public void variesWithWeigth() {
        final double oldSum= this.testObj.calculateTax(this.car).sum;
        this.car.setWeight(this.car.getWeight()*2);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(oldSum<newSum);
    }

    @Test
    public void variesWithEffect() {
        final double oldSum= this.testObj.calculateTax(this.car).sum;
        final Engine engine= this.car.getEngine();
        engine.setKw(engine.getKw()-1);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(oldSum>newSum);
    }

    @Test
    public void variesWithAge() {
        final double oldSum= this.testObj.calculateTax(this.car).sum;
        this.car.setYear(this.car.getYear()-2);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(oldSum>newSum);
    }

    @Test
    @Override
    public void handlesFutureCars() {
        final double oldSum= this.testObj.calculateTax(this.car).sum;
        this.car.setYear(9999);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        final int diff= (int) (oldSum-newSum);
        assertEquals(0, diff);
    }

    @Test
    @Override
    public void handlesAncientCars() {
        this.car.setYear(10);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(newSum>=0);
    }

    @Test
    @Override
    public void handlesNoEngine() {
        this.car.setEngine(null);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(newSum>0);
    }
}
