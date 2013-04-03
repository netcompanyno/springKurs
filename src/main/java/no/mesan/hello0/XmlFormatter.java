package no.mesan.hello0;

/** Format message as XML. */
public class XmlFormatter  {
    public String format(final String greet, final String recipient) {
       return "<message to='" + recipient + "'>" +
       		  "<greet>" + greet + "</greet>" +
       		  "</message>";
   }
}
