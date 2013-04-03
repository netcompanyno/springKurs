package no.mesan.spring.hello.annotated;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/** Creates a formatted message. */
@Component
public class Greeter {

    @Autowired public @Value("Hello") String greeting;
    public @Resource(name="xmlFormatter") Formatter formatter;

    public String greet(final String recipient) {
        return this.formatter.format(this.greeting, recipient);
    }

    public String getGreeting() {
        return this.greeting;
    }

    public void setGreeting(final String greeting) {
        this.greeting= greeting;
    }
}
