package no.mesan.spring.felles;

/**
 * Formatterer beskjeder som HTML.
 */
public class HtmlFormatter extends NoeSomBrukesForASjekkeOppgaver {

    public String format(final String greet, final String recipient) {
        metodeKalt();
        return "<b>" + greet + ", <i>" + recipient + "</i>!</b>";
    }
}
