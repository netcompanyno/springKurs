package no.mesan.spring.hello.felles;

/** Format message as HTML. */
public class HtmlFormatter {
    public String format(final String greet, final String recipient) {
       return "<b>" + greet + ", <i>" + recipient + "</i>!</b>";
   }
}
