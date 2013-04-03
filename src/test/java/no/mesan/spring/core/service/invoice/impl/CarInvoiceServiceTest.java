package no.mesan.spring.core.service.invoice.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import no.mesan.spring.core.service.domain.car.TestCarRepository;
import no.mesan.spring.core.service.tax.Tax;

import static org.junit.Assert.assertEquals;


/**
 * Test {@link CarInvoiceService}.
 */
public class CarInvoiceServiceTest  /*extends BaseSpringTest*/ {

    private final CarInvoiceService service= new CarInvoiceService();
    private TestCarRepository testRepo;

    @Before
    public void setUp()  {
        this.testRepo= new TestCarRepository();
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
