package no.mesan.spring.xml;


/** Creates a formatted message. */
public class Greeter {

    public String greeting= "Hello";
    public Formatter formatter;

    public String greet(final String recipient) {
        return this.formatter.format(this.greeting, recipient);
    }

    public String getGreeting() {
        return this.greeting;
    }

    public void setGreeting(final String greeting) {
        this.greeting= greeting;
    }

    public Formatter getFormatter() {
        return this.formatter;
    }

    public void setFormatter(final Formatter formatter) {
        this.formatter= formatter;
    }
}
