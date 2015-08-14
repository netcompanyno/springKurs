package no.mesan.spring.hello.felles;

/** Format message as XML. */
public class XmlFormatter  {

    //Dette er egentlig fyfy da det er tilstand og public, men har det med for å få sjekket at gaven er løst
    public boolean harBlittKalt;

    public String format(final String greet, final String recipient) {
        harBlittKalt = true;
        return "<message to='" + recipient + "'>" +
                "<greet>" + greet + "</greet>" +
                "</message>";
    }
}
