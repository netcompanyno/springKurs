package no.mesan.spring.hello.annotated;

import org.springframework.stereotype.Component;

/** Format message as XML. */
@Component
public class XmlFormatter implements Formatter {
    @Override
    public String format(final String greet, final String recipient) {
       return "<message to='" + recipient + "'>" +
       		  "<greet>" + greet + "</greet>" +
       		  "</message>";
   }
}
