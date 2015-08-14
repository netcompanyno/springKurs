package no.mesan.spring.hello.felles;

/** Format message as plain text. */
public class TextFormatter {
    //Dette er egentlig fyfy da det er tilstand og public, men har det med for å få sjekket at oppgaven er løst
    public boolean harBlittKalt;

    public String format(final String greet, final String recipient) {
        harBlittKalt = true;
        return greet + ", " + recipient + "!";
    }
}
