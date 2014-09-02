package no.mesan.spring.core.service.invoice;

import java.util.List;

import no.mesan.spring.core.domain.car.Car;
import no.mesan.spring.core.service.tax.Tax;


/**
 * Produksjon av avgifter for biler.
 */
public interface InvoiceService {

    /**
     * Årsavgiftskjøring for <b>alle</b> biler som skal ha avgift.
     * @return Liste av avgifter -- kun fakturaer der beløpet er ulik 0
     */
    List<Tax> annualTax();

    /**
     * Engangsavgift på bil.
     *
     * @param car Bil
     * @return Beregnet avgift
     */
    List<Tax> importTax(List<Car> car);

    /**
     * Engangsavgift på alle biler som ikke er beregnet tidligere.
     *
     * @return Beregnet avgift
     */
    List<Tax> importTax();
}
