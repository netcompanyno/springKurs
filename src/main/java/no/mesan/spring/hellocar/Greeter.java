package no.mesan.spring.hellocar;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/** Creates a formatted message. */
@Component
public class Greeter {

    @Autowired @Value("Hello")
    private String greeting;
    @Resource(name="greetingFormatter")
    private Formatter formatter;

    public String greet(final String recipient) {
        return this.formatter.format(this.greeting, recipient);
    }
}
