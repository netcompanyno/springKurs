package no.mesan.spring.hello.annotated;

import org.springframework.stereotype.Component;

/** Format message as plain text. */
@Component
public class TextFormatter implements Formatter {
    @Override
    public String format(final String greet, final String recipient) {
        return greet + ", " + recipient + "!";
    }
}
