package no.mesan.spring.core.service.invoice.impl;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;

import no.mesan.spring.core.domain.car.Car;
import no.mesan.spring.core.service.tax.Tax;
import no.mesan.spring.core.service.tax.TaxService;
import no.mesan.spring.core.service.tax.TaxSpec;
import no.mesan.spring.core.service.tax.impl.AnnualTaxServiceTest;


/**
 * Kjør årsavgifttestene via InvoiceService.
 */
public class CarInvoiceServiceAsAnnualTaxServiceTest extends AnnualTaxServiceTest {
    private final CarInvoiceService carInvoiceService= new CarInvoiceService();

    private static final Tax NO_TAX;
    static {
        final List<TaxSpec> list= new LinkedList<TaxSpec>();
        list.add(new TaxSpec("-", 0));
        NO_TAX= new Tax(list);
    }

    private class TaxServiceAdapter implements TaxService {
        @Override
        public Tax calculateTax(final Car car) {
            final List<Car> list= new LinkedList<Car>();
            list.add(car);
            final CarInvoiceService svc= CarInvoiceServiceAsAnnualTaxServiceTest.this.carInvoiceService;
            final List<Tax> annualTax= svc.annualTax(list);
            return (annualTax.size()>0)? annualTax.get(0)
                                       : NO_TAX;
        }
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
        this.testObj= new TaxServiceAdapter();
    }
}
