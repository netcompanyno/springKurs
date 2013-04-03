package no.mesan.spring.core.service.tax.impl;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import no.mesan.spring.core.domain.car.Car;
import no.mesan.spring.core.domain.car.Engine;
import no.mesan.spring.core.service.tax.Tax;
import no.mesan.spring.core.service.tax.TaxRates;
import no.mesan.spring.core.service.tax.TaxService;
import no.mesan.spring.core.service.tax.TaxSpec;


/**
 * Årsavgift...
 * Kalkuleres slik:
 *   Ingen motor: ingen avgift
 *   7500kg eller mer: høy avgift
 *   ellers lav avgift
 *   B: aldersfradrag på A
 *   SUM: A-B
 */
@Service
public class AnnualTaxService implements TaxService {

    @Inject
    private TaxRates taxRates;

    @Value("${taxes.rates.annual.small.name}")
    private String lowName;

    @Value("${taxes.rates.annual.big.name}")
    private String highName;

    @Value("${taxes.rates.annual.none.name}")
    private String noneName;

    @Override
    public Tax calculateTax(final Car car) {
        final List<TaxSpec> list= new LinkedList<TaxSpec>();
        final Engine engine= car.getEngine();
        final int weight= car.getWeight();
        if ( engine==null ) list.add(noTax());
        else list.add(weightTax(weight));
        return new Tax(list);
    }

    private TaxSpec weightTax(final int weight) {
        if ( weight > this.taxRates.getAnnualSmallWeightMax() ) {
            return new TaxSpec(this.highName, this.taxRates.getAnnualBigCar());
        }
        return new TaxSpec(this.lowName, this.taxRates.getAnnualSmallCar());
    }

    private TaxSpec noTax() {
        return new TaxSpec(this.noneName, 0);
    }
}
