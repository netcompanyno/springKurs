package no.mesan.spring.hello.xml;

import org.junit.Test;

import no.mesan.spring.hello.xml.HtmlFormatter;

import static org.junit.Assert.assertTrue;


public class HtmlFormatterTest {

    @Test
    public void testFormatAddsFormatting() {
        final String res= new HtmlFormatter().format("foo", "bar");
        assertTrue(res.contains("<i>"));
        assertTrue(res.contains("</b>"));
        assertTrue(res.contains("foo"));
        assertTrue(res.contains("bar"));
    }

}
