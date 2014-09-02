package no.mesan.spring.hello.xml;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import no.mesan.spring.hello.xml.Greeter;
import no.mesan.spring.hello.xml.HtmlFormatter;
import no.mesan.spring.hello.xml.TextFormatter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@ContextConfiguration("Hello.spring.xml")
public class GreeterTest extends AbstractJUnit4SpringContextTests {

    private Greeter greeter= new Greeter();

    @Test
    public void textGreeting() {
        this.greeter.setFormatter(new TextFormatter());
        final String greet= this.greeter.greet("me");
        assertTrue(greet.contains(this.greeter.greeting));
        assertTrue(greet.contains("me"));
    }

    @Test
    public void htmlGreeting() {
        this.greeter.setFormatter(new HtmlFormatter());
        final String greet= this.greeter.greet("me");
        assertTrue(greet.contains(this.greeter.greeting));
        assertTrue(greet.contains("me"));
        assertTrue(greet.contains("<i>"));
        assertTrue(greet.contains("</b>"));
    }

    @Test
    public void springConfigured() {
        this.greeter= this.applicationContext.getBean(Greeter.class);
        assertNotNull(this.greeter);
        assertTrue(this.greeter.greet("me").startsWith("<message"));
    }
}
