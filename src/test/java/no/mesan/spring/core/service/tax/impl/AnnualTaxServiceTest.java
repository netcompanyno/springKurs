package no.mesan.spring.core.service.tax.impl;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Test {@link AnnualTaxService}.
 */
public class AnnualTaxServiceTest extends TaxServiceTest {

    @Inject private AnnualTaxService service;


    @Before
    public void setUp() {
        this.testObj= this.service;
    }

    @Test
    public void basicStructure() {
        assertEquals(1, this.testObj.calculateTax(this.car).elements.size());
    }

    @Test
    public void basicStructureNoEngine() {
        this.car.setEngine(null);
        assertEquals(1, this.testObj.calculateTax(this.car).elements.size());
    }

    @Test
    public void variesWithWeigth() {
        this.car.setWeight(this.rates.getAnnualSmallWeightMax()/2);
        final double oldSum= this.testObj.calculateTax(this.car).sum;
        this.car.setWeight(this.rates.getAnnualSmallWeightMax()*2);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(oldSum<newSum);
    }

    @Test
    public void limitIsInclusive() {
        this.car.setWeight(this.rates.getAnnualSmallWeightMax()/2);
        final double oldSum= this.testObj.calculateTax(this.car).sum;
        this.car.setWeight(this.rates.getAnnualSmallWeightMax());
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(oldSum==newSum);
    }

    @Test
    public void noEngineNoTax() {
        this.car.setEngine(null);
        final double oldSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(oldSum==0.0D);
    }

    @Override
    @Test
    public void handlesFutureCars() {
        this.car.setYear(9999);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(newSum>=0);
    }

    @Override
    @Test
    public void handlesAncientCars() {
        this.car.setYear(10);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(newSum>=0);
    }

    @Override
    @Test
    public void handlesNoEngine() {
        this.car.setEngine(null);
        final double newSum= this.testObj.calculateTax(this.car).sum;
        assertTrue(newSum>=0);
    }
}
