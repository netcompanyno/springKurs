package com.netcompany.spring.oppgave1;

import com.netcompany.spring.felles.HtmlFormatter;

/**
 * Denne klassen brukes i forbindelse med oppgaver
 */
public class HelloFormattingServiceXml {

    private static final String GREET = "Hello";

    private final HtmlFormatter htmlFormatter = new HtmlFormatter();

    public String getHello(final String recipient) {
        return htmlFormatter.format(GREET, recipient);
    }
}
