package no.mesan.spring.felles;

/** Format message as XML. */
public class XmlFormatter  {

    //Dette er egentlig fyfy da det er tilstand og public, men har det med for � f� sjekket at gaven er l�st
    public boolean harBlittKalt;

    public String format(final String greet, final String recipient) {
        harBlittKalt = true;
        return "<message to='" + recipient + "'>" +
                "<greet>" + greet + "</greet>" +
                "</message>";
    }
}
