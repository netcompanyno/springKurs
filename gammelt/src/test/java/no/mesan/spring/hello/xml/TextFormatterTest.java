package no.mesan.spring.hello.xml;

import org.junit.Test;

import no.mesan.spring.hello.xml.TextFormatter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TextFormatterTest {

    @Test
    public void testFormatAddsFormatting() {
        final String res= new TextFormatter().format("foo", "bar");
        assertFalse(res.contains("<"));
        assertTrue(res.contains("foo"));
        assertTrue(res.contains("bar"));
    }

}
