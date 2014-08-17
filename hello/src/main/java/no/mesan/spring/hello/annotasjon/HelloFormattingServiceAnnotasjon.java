package no.mesan.spring.hello.annotasjon;

import no.mesan.spring.hello.felles.HtmlFormatter;

/** Hello world! */
public class HelloFormattingServiceAnnotasjon {

    private static final String GREET = "Hello";

    public String getHello(final String recipient) {

        //TODO -- vil kunne konfigurere denne!
        return new HtmlFormatter().format(GREET, recipient);
    }
}
