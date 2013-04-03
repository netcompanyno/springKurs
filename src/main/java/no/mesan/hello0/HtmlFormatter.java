package no.mesan.hello0;

/** Format message as HTML. */
public class HtmlFormatter {
    public String format(final String greet, final String recipient) {
       return "<b>" + greet + ", <i>" + recipient + "</i>!</b>";
   }
}
