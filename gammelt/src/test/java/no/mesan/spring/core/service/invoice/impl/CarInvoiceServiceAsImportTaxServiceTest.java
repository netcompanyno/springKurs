package no.mesan.spring.core.service.invoice.impl;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;

import no.mesan.spring.core.domain.car.Car;
import no.mesan.spring.core.service.tax.Tax;
import no.mesan.spring.core.service.tax.TaxService;
import no.mesan.spring.core.service.tax.impl.ImportTaxServiceTest;


/**
 * Kjør engangsavgifttestene via InvoiceService.
 */
public class CarInvoiceServiceAsImportTaxServiceTest extends ImportTaxServiceTest {

    private final CarInvoiceService carInvoiceService= new CarInvoiceService();

    private class TaxServiceAdapter implements TaxService {
        @Override
        public Tax calculateTax(final Car car) {
            final List<Car> list= new LinkedList<Car>();
            list.add(car);
            final CarInvoiceService svc= CarInvoiceServiceAsImportTaxServiceTest.this.carInvoiceService;
            final List<Tax> annualTax= svc.importTax(list);
            return annualTax.get(0);
        }
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
        this.testObj= new TaxServiceAdapter();
    }
}
