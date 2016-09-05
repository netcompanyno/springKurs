package no.mesan.spring.felles;

import no.mesan.spring.felles.ikke.ror.NoeSomBrukesForASjekkeOppgaver;

/**
 * Formatterer beskjeder som XML.
 *
 * Denne filen kan endres!
 */
public class XmlFormatter extends NoeSomBrukesForASjekkeOppgaver {

    public String format(final String greet, final String recipient) {
        metodeKalt();
        return "<message to='" + recipient + "'>" +
               "<greet>" + greet + "</greet>" +
               "</message>";
    }
}
