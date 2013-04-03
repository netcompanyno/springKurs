package no.mesan.spring.hello.xml;

/** Format message as XML. */
public class XmlFormatter implements Formatter {
    @Override
    public String format(final String greet, final String recipient) {
       return "<message to='" + recipient + "'>" +
       		  "<greet>" + greet + "</greet>" +
       		  "</message>";
   }
}
