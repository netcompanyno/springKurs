package no.mesan.spring.core.service.tax;

import no.mesan.spring.core.domain.car.Car;


/**
 * Generelt grensesnitt for bilavgifter.
 */
public interface TaxService {
    /**
     * Beregn en avgift for angitt bil.
     * @param car Avgiftsobjekt
     * @return Beregning av avgiften
     */
    Tax calculateTax(Car car);
}
