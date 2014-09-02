package no.mesan.spring.core.service.util;


/**
 * Tjenester for dato/tid.
 */
public interface TimeService {
    /** Gjeldende avgiftsår.
     * @return Årstall */
    int currentTaxYear();
}
