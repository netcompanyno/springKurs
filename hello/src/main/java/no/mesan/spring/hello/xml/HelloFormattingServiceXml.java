package no.mesan.spring.hello.xml;

import no.mesan.spring.hello.felles.HtmlFormatter;

/** Hello world! */
public class HelloFormattingServiceXml {

    private static final String GREET = "Hello";

    public String getHello(final String recipient) {

        //TODO -- vil kunne konfigurere denne!
        return new HtmlFormatter().format(GREET, recipient);
    }
}
