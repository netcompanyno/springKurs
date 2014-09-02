package no.mesan.spring.core.service.tax;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Gjeldende avgifter.  Kommer sikkert til å øke.
 */
public class TaxRates {

    private final double importBase;
    private final double weightRate;
    private final double effectRate;
    private final double ageReductionFactor;
    private final double annualSmallCar;
    private final int annualSmallWeightMax;
    private final double annualBigCar;


    /**
     * Default constructor for TaxRates.
     */
    public TaxRates() {
        final InputStream stream=
            getClass().getResourceAsStream("/no/mesan/spring/core/carTax.properties");
        final Properties props= new Properties();
        try {
            props.load(stream);
        }
        catch (final IOException e) {
            throw new RuntimeException(e);
        }
        this.importBase= getDouble(props, "import.base");
        this.weightRate= getDouble(props, "import.weightRate");
        this.effectRate= getDouble(props, "import.effectRate");
        this.ageReductionFactor= getDouble(props, "import.ageReductionFactor");
        this.annualSmallCar= getDouble(props, "annual.smallCars");
        this.annualBigCar= getDouble(props, "annual.bigCars");
        this.annualSmallWeightMax=
            Integer.parseInt(props.getProperty("taxes.rates.annual.small.weightMax"));
    }

    private double getDouble(final Properties props, final String key) {
        return Double.parseDouble(props.getProperty("taxes.rates." + key));
    }

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
