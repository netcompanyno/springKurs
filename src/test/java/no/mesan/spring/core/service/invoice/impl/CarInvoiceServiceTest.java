package no.mesan.spring.core.service.invoice.impl;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import no.mesan.spring.core.service.domain.car.TestCarRepository;
import no.mesan.spring.core.service.tax.Tax;
import no.mesan.utils.test.BaseSpringTest;

import static org.junit.Assert.assertEquals;


/**
 * Test {@link CarInvoiceService}.
 */
@ContextConfiguration("/no/mesan/spring/core/carTax.spring.xml")
public class CarInvoiceServiceTest extends BaseSpringTest {

    @Inject private CarInvoiceService service;
    @Inject private TestCarRepository testRepo;

    @Before
    public void setUp()  {
        this.testRepo.reset();
        this.service.setRepository(this.testRepo);
    }

    @Test
    public void allCarsInAnnualList() {
        final List<Tax> tax= this.service.annualTax();
        assertEquals(this.testRepo.totalNoOfCars()-1, tax.size());
    }

    @Test
    public void allCarsInImportList() {
        final List<Tax> tax= this.service.importTax();
        assertEquals(8, tax.size());
    }

    @Test
    public void notTaxedTwice() {
        this.service.importTax();
        final List<Tax> tax2= this.service.importTax();
        assertEquals(0, tax2.size());
    }
}
