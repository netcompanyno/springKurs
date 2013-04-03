package no.mesan.spring.core.service.tax.impl;

import org.junit.Before;
import org.junit.Test;

import no.mesan.spring.core.domain.car.Car;
import no.mesan.spring.core.service.domain.car.TestCarRepository;
import no.mesan.spring.core.service.tax.Tax;
import no.mesan.spring.core.service.tax.TaxRates;
import no.mesan.spring.core.service.tax.TaxService;
import no.mesan.spring.core.service.tax.TaxSpec;
import no.mesan.spring.core.service.util.StdTimeService;
import no.mesan.spring.core.service.util.TimeService;
import no.mesan.utils.Strings;

import static org.junit.Assert.assertTrue;


/**
 * Base class for testing {@link TaxService}.
 */
public abstract class TaxServiceTest /*extends BaseSpringTest*/ {

    protected TaxRates rates;
    protected TaxService testObj;
    protected TimeService timeService;
    protected Car car;

    @Before
    public void commonSetUp() {
        this.rates= new TaxRates();
        this.timeService= new StdTimeService();
        this.car= TestCarRepository.createCar(100, "Little Red | Corvette | 1982 | 1999 | 250");
        this.car.setYear(this.timeService.currentTaxYear());
    }

    @Test
    public void basicTaxStructure() {
        final Tax tax= this.testObj.calculateTax(this.car);
        assertTrue(tax.sum>0);
        for (final TaxSpec spec : tax.elements) {
            assertTrue(!Strings.isEmpty(spec.description));
        }
    }

    @Test
    public void basicTaxStructureNoEngine() {
        this.car.setEngine(null);
        final Tax tax= this.testObj.calculateTax(this.car);
        assertTrue(tax.sum>=0);
        for (final TaxSpec spec : tax.elements) {
            assertTrue(!Strings.isEmpty(spec.description));
        }
    }

    public abstract void handlesFutureCars();
    public abstract void handlesAncientCars();
    public abstract void handlesNoEngine();
}
