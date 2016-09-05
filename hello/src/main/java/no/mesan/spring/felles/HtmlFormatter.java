package no.mesan.spring.felles;

import no.mesan.spring.felles.ikke.ror.NoeSomBrukesForASjekkeOppgaver;

/**
 * Formatterer beskjeder som HTML.
 *
 * Denne filen kan endres!
 */
public class HtmlFormatter extends NoeSomBrukesForASjekkeOppgaver {

    public String format(final String greet, final String recipient) {
        metodeKalt();
        return "<b>" + greet + ", <i>" + recipient + "</i>!</b>";
    }
}
