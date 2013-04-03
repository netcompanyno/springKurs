package no.mesan.spring.core.service.tax;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Spesifikasjon av en avgift.
 * Immutable.
 */
public class Tax {
    public final List<TaxSpec> elements;
    public final double sum;

    public Tax(final List<TaxSpec> parts) {
        double partSum= 0;
        final LinkedList<TaxSpec> list= new LinkedList<TaxSpec>();
        if ( parts!=null ) {
            for (final TaxSpec taxSpec : parts) {
                list.add(taxSpec);
                partSum+= taxSpec.sum;
            }
        }
        this.elements= Collections.unmodifiableList(list);
        this.sum= partSum;
    }

    @Override
    public String toString() {
        final StringBuilder sb= new StringBuilder();
        for (final TaxSpec tSpec : this.elements) {
            sb.append(tSpec.description);
            sb.append('\t');
            sb.append(tSpec.sum);
            sb.append('\n');
        }
        sb.append('=');
        sb.append(this.sum);
        return sb.toString();
    }
}
