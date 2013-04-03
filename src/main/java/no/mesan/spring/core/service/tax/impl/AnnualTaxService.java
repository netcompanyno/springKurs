package no.mesan.spring.core.service.tax.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

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
public class AnnualTaxService implements TaxService {

    private final TaxRates taxRates;
    private final String lowName;
    private final String highName;
    private final String noneName;


    /**
     * Default constructor for AnnualTaxService.
     */
    public AnnualTaxService() {
        this.taxRates= new TaxRates();
        final InputStream stream=
            getClass().getResourceAsStream("/no/mesan/spring/core/carTax.properties");
        final Properties props= new Properties();
        try {
            props.load(stream);
        }
        catch (final IOException e) {
            throw new RuntimeException(e);
        }
        this.lowName= props.getProperty("taxes.rates.annual.small.name");
        this.highName= props.getProperty("taxes.rates.annual.big.name");
        this.noneName= props.getProperty("taxes.rates.annual.none.name");
    }

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
