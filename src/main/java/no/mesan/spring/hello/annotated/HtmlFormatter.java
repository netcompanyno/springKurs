package no.mesan.spring.hello.annotated;

import org.springframework.stereotype.Component;


/** Format message as HTML. */
@Component
public class HtmlFormatter implements Formatter {
    @Override
    public String format(final String greet, final String recipient) {
       return "<b>" + greet + ", <i>" + recipient + "</i>!</b>";
   }
}
