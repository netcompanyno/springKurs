package no.mesan.spring.hello.xml;

import org.junit.Test;

import no.mesan.spring.hello.xml.XmlFormatter;

import static org.junit.Assert.assertTrue;


public class XmlFormatterTest {

    @Test
    public void testFormatAddsFormatting() {
        final String res= new XmlFormatter().format("foo", "bar");
        assertTrue(res.contains("<message"));
        assertTrue(res.contains("foo"));
        assertTrue(res.contains("bar"));
    }

}
