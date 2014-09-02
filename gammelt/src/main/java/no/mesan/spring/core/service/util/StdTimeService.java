package no.mesan.spring.core.service.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;


/**
 * Standard implementasjon av tidstjenester.
 */
public class StdTimeService implements TimeService {

    /** Avgiftsår. */
    private int taxYear= Calendar.getInstance().get(Calendar.YEAR);


    /**
     * Default constructor for StdTimeService.
     */
    public StdTimeService() {
        final InputStream stream=
            getClass().getResourceAsStream("/no/mesan/spring/core/carTax.properties");
        final Properties props= new Properties();
        try {
            props.load(stream);
        }
        catch (final IOException e) {
            throw new RuntimeException(e);
        }
        this.taxYear= Integer.parseInt(props.getProperty("taxes.taxYear"));
    }

    public void setTaxYear(final int taxYear) {
        this.taxYear= taxYear;
    }

    @Override
    public int currentTaxYear() {
        return this.taxYear;
    }

}
