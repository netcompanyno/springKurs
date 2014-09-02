package no.mesan.spring.core.service.tax;


/**
 * Et element i en avgift.
 * Immutable.
 */
public class TaxSpec {

    public final String description;
    public final double sum;

    public TaxSpec(final String description, final double sum) {
        this.description= description;
        this.sum= sum;
    }
}
