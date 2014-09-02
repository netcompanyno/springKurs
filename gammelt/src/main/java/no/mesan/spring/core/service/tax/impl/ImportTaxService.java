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
import no.mesan.spring.core.service.util.StdTimeService;
import no.mesan.spring.core.service.util.TimeService;


/**
 * Engangsavgift...
 * Kalkuleres slik:
 *   A: basisavgift + vektbasert + effektbasert
 *   B: aldersfradrag på A (aldri >0, aldri mer enn A)
 *   SUM: A-B
 */
public class ImportTaxService implements TaxService {

    private static final double PERCENT= 0.01D;
    private final TaxRates taxRates;
    private final TimeService timeService;
    private final String baseName;
    private final String weightName;
    private final String effectName;
    private final String ageName;


    /**
     * Default constructor for ImportTaxService.
     */
    public ImportTaxService() {
        this.taxRates= new TaxRates();
        this.timeService= new StdTimeService();
        final InputStream stream=
            getClass().getResourceAsStream("/no/mesan/spring/core/carTax.properties");
        final Properties props= new Properties();
        try {
            props.load(stream);
        }
        catch (final IOException e) {
            throw new RuntimeException(e);
        }
        this.baseName= props.getProperty("taxes.rates.import.base.name");
        this.weightName= props.getProperty("taxes.rates.import.weight.name");
        this.effectName= props.getProperty("taxes.rates.import.effect.name");
        this.ageName= props.getProperty("taxes.rates.import.age.name");
    }

    @Override
    public Tax calculateTax(final Car car) {
        final List<TaxSpec> list= new LinkedList<TaxSpec>();
        double soFar= 0;
        soFar+= basePart(list);
        soFar+= weightPart(car, list);
        soFar+= effectPart(car.getEngine(), list);
        agePart(car, list, soFar);
        return new Tax(list);
    }

    private double basePart(final List<TaxSpec> list) {
        final double base= this.taxRates.getImportBase();
        list.add(new TaxSpec(this.baseName, base));
        return base;
    }

    private double weightPart(final Car car, final List<TaxSpec> list) {
        final double weightPart= car.getWeight() * this.taxRates.getWeightRate();
        list.add(new TaxSpec(this.weightName, weightPart));
        return weightPart;
    }

    private double effectPart(final Engine engine, final List<TaxSpec> list) {
        if ( engine==null ) {
            return 0.0D;
        }
        final double effectPart= engine.getKw() * this.taxRates.getEffectRate();
        list.add(new TaxSpec(this.effectName, effectPart));
        return effectPart;
    }

    private void agePart(final Car car, final List<TaxSpec> list, final double soFar) {
        final double reductionFactor=
            Math.abs(this.taxRates.getAgeReductionFactor()) * PERCENT;
        final double ageReduction= -ageReduction(car, soFar, reductionFactor);
        list.add(new TaxSpec(this.ageName, ageReduction));
    }

    private double ageReduction(final Car car, final double soFar,
                                final double reductionFactor) {
        final double ageReduction= soFar * age(car) * reductionFactor;
        if ( ageReduction > soFar ) {
            return soFar;
        }
        return ageReduction;
    }

    private int age(final Car car) {
        int age= car.age(this.timeService.currentTaxYear());
        if ( age < 0 ) {
            age= 0;
        }
        return age;
    }
}
