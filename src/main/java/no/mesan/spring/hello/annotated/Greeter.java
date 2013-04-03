package no.mesan.spring.hello.annotated;



/** Creates a formatted message. */
public class Greeter {

    public String greeting;
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
}
