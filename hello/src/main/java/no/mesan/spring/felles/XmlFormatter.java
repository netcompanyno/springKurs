package no.mesan.spring.felles;

/**
 * Formatterer beskjeder som XML.
 */
public class XmlFormatter extends NoeSomBrukesForASjekkeOppgaver {

    public String format(final String greet, final String recipient) {
        metodeKalt();
        return "<message to='" + recipient + "'>" +
               "<greet>" + greet + "</greet>" +
               "</message>";
    }
}
