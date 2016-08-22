package no.mesan.spring.felles;

/**
 * Formatterer beskjeder som tekst.
 */
public class TextFormatter extends NoeSomBrukesForASjekkeOppgaver {

    public String format(final String greet, final String recipient) {
        metodeKalt();
        return greet + ", " + recipient + "!";
    }
}
