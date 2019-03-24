package com.netcompany.spring.oppgave2;

import com.netcompany.spring.felles.HtmlFormatter;

/**
 * Hello world!
 */
public class HelloFormattingServiceAnnotasjon {

    private static final String GREET = "Hello";

    private final HtmlFormatter htmlFormatter = new HtmlFormatter();

    public String getHello(final String recipient) {
        return htmlFormatter.format(GREET, recipient);
    }
}
