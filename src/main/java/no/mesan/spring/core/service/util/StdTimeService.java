package no.mesan.spring.core.service.util;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * Standard implementasjon av tidstjenester.
 */
@Service
public class StdTimeService implements TimeService {

    /** Avgiftsår. */
    @Value("${taxes.taxYear}")
    private int taxYear= Calendar.getInstance().get(Calendar.YEAR);


    public void setTaxYear(final int taxYear) {
        this.taxYear= taxYear;
    }

    @Override
    public int currentTaxYear() {
        return this.taxYear;
    }

}
