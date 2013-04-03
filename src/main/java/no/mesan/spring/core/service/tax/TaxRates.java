package no.mesan.spring.core.service.tax;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Gjeldende avgifter.  Kommer sikkert til å øke.
 */
@Component
public class TaxRates {

    @Value("${taxes.rates.import.base}")
    private double importBase;

    @Value("${taxes.rates.import.weightRate}")
    private double weightRate;

    @Value("${taxes.rates.import.effectRate}")
    private double effectRate;

    @Value("${taxes.rates.import.ageReductionFactor}")
    private double ageReductionFactor;

    @Value("${taxes.rates.annual.smallCars}")
    private double annualSmallCar;

    @Value("${taxes.rates.annual.small.weightMax}")
    private int annualSmallWeightMax;

    @Value("${taxes.rates.annual.bigCars}")
    private double annualBigCar;

    public double getImportBase() {
        return this.importBase;
    }

    public double getWeightRate() {
        return this.weightRate;
    }

    public double getEffectRate() {
        return this.effectRate;
    }

    public double getAgeReductionFactor() {
        return this.ageReductionFactor;
    }

    public double getAnnualSmallCar() {
        return this.annualSmallCar;
    }

    public int getAnnualSmallWeightMax() {
        return this.annualSmallWeightMax;
    }

    public double getAnnualBigCar() {
        return this.annualBigCar;
    }
}
