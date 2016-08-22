package no.mesan.spring.oppgave1;

import no.mesan.spring.felles.HtmlFormatter;

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
