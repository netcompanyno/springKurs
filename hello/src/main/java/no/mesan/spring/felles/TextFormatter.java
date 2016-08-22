package no.mesan.spring.felles;

/** Format message as plain text. */
public class TextFormatter {
    //Dette er egentlig fyfy da det er tilstand og public, men har det med for � f� sjekket at oppgaven er l�st
    public boolean harBlittKalt;

    public String format(final String greet, final String recipient) {
        harBlittKalt = true;
        return greet + ", " + recipient + "!";
    }
}
