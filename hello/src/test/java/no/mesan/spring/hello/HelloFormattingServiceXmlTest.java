package no.mesan.spring.hello;

import static org.junit.Assert.*;

import no.mesan.spring.hello.felles.HtmlFormatter;
import no.mesan.spring.hello.felles.TextFormatter;
import no.mesan.spring.hello.felles.XmlFormatter;
import no.mesan.spring.hello.xml.HelloFormattingServiceXml;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Første sett med oppgaver, konfigurasjon av Spring vha xml.
 */
@Ignore
public class HelloFormattingServiceXmlTest {

    private HelloFormattingServiceXml helloFormattingServiceXml;
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring/applicationContext-xml.xml");
        helloFormattingServiceXml = applicationContext.getBean(HelloFormattingServiceXml.class);
    }

    /**
     * Oppgave 1:
     * Definer en bønne for {@link HelloFormattingServiceXml} ved hjelp av xml, i filen applicationContext-xml.xml.
     */
    @Test
    public void lagBonneForHelloFormattingService() {
        assertNotNull(helloFormattingServiceXml);
    }

    /**
     * Oppgave 2:
     * HelloFormattingService new-er HtmlFormatter. Vi ønsker nå å benytte Spring til å inject denne i stedet for å
     * kalle new.
     *
     * Bruk testen sePaUtskrift for å se hva {@link HelloFormattingServiceXml} produserer.
     * Få deretter testene under til å kjøre, en og en (alle blir ikke grønne samtidig..)
     */
    @Test
    public void sePaUtskrift() {
        System.out.println(helloFormattingServiceXml.getHello("world"));
    }

    @Test
    public void htmlFormatteringMedBonne() {
        assertEquals("<b>Hello, <i>world</i>!</b>", helloFormattingServiceXml.getHello("world"));

        assertNotNull(applicationContext.getBean(HtmlFormatter.class));
    }

    /**
     * Tips:
     *      - Nå trenger man en variabel som kan holde på alle tre formatter-klassene. Har de noe til felles?
     */
    @Test
    public void xmlFormatteringMedBonne() {
        assertEquals("<message to='world'><greet>Hello</greet></message>", helloFormattingServiceXml.getHello("world"));
        assertNotNull(applicationContext.getBean(XmlFormatter.class));
    }

    @Test
    public void textFormatteringMedBonne() {
        assertEquals("Hello, world!", helloFormattingServiceXml.getHello("world"));
        assertNotNull(applicationContext.getBean(TextFormatter.class));
    }

    /**
     * Oppgave 3:
     * HelloFormattingService kan nå bare si hallo på ett språk. Derfor ønsker vi å gjøre tekststrengen som holder på
     * "Hello" konfigurerbart, og injecte denne ved hjelp av Spring. Sørg for at testen under blir grønn ved å injecte
     * riktig verdi.
     *
     * For enkelhets skyld, bruk {@link TextFormatter}.
     *
     */
    @Test
    public void holaMundo() {
        assertEquals("¡Hola, mundo!", helloFormattingServiceXml.getHello("mundo"));
    }

    /**
     * Oppgave 4 (bonus):
     *
     * Flytt definisjonen av hva "hallo" skal være ut i property-filen "spring.properties".
     *
     * Tips:
     *       - For å referere til en property, bruk: ${navn.pa.property}
     *       - Man må fortelle Spring hvor den finner properties...
     */
    @Test
    public void bonjourMonde() {
        assertEquals("Bonjour, monde!", helloFormattingServiceXml.getHello("monde"));
    }

    /**
     * Oppgave 5 (bonus):
     *
     * Gjør om til constructor-arg injection hvis du brukte property-injection, og vice versa.
     */
}
