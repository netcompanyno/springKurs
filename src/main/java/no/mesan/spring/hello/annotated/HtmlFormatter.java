package no.mesan.spring.hello.annotated;



/** Format message as HTML. */
public class HtmlFormatter implements Formatter {
    @Override
    public String format(final String greet, final String recipient) {
       return "<b>" + greet + ", <i>" + recipient + "</i>!</b>";
   }
}
