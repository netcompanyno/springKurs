package no.mesan.spring.core.service.tax;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Test {@link Tax}.
 */
public class TaxTest {

    private LinkedList<TaxSpec> list;
    private Tax tax;


    @Before
    public void setUp() {
        this.list= new LinkedList<TaxSpec>();
        this.list.add(new TaxSpec("text", 0));
        this.tax= new Tax(this.list);
    }

    @Test
    public void notModifiableFromSource() {
        this.list.add(new TaxSpec("bad", 0));
        assertEquals(1, this.tax.elements.size());
    }


    @Test(expected=UnsupportedOperationException.class)
    public void notDirectlyModifiable() {
        this.tax.elements.add(new TaxSpec("bad", 0));
    }
}
