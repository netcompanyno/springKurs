package com.netcompany.spring.oppgave1;

import static org.junit.Assert.*;

import com.netcompany.spring.felles.HtmlFormatter;
import com.netcompany.spring.felles.TextFormatter;
import com.netcompany.spring.felles.XmlFormatter;
import com.netcompany.spring.util.TestHjelper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Første sett med oppgaver, konfigurasjon av Spring vha xml.
 *
 * Kjør èn og èn test. Det er ikke meningen at flere tester skal kjøres samtidig.
 *
 * OBS! Det er ikke lov å endre denne filen, bortsett fra fjerning/utkommentering av Ignore-annotasjoner.
 */
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
     * TODO: Oppgave 1:
     * Definer en bønne for {@link HelloFormattingServiceXml} ved hjelp av xml, i filen applicationContext-xml.xml.
     */
    @Test
    public void lagBonneForHelloFormattingService() {
        assertNotNull("Mangler bønne for HelloFormattingServiceXml!", helloFormattingServiceXml);
    }

    /**
     * TODO: Oppgave 2:
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

    /**
     * Sørg for å injecte en bønne av klassen HtmlFormatter i HelloFormattingServiceXml.
     */
    @Test
    public void htmlFormatteringMedBonne() {
        assertEquals("<b>Hello, <i>world</i>!</b>",
                     helloFormattingServiceXml.getHello("world"));

        assertNotNull("Mangler bønne for HtmlFormatter!", applicationContext.getBean(HtmlFormatter.class));
        final HtmlFormatter htmlFormatter = TestHjelper.hentFeltAvType(helloFormattingServiceXml, HtmlFormatter.class);
        assertSame("HtmlFormatter er ikke injectet i HelloFormattingServiceXml!",
                   applicationContext.getBean(HtmlFormatter.class),
                   htmlFormatter);
        assertTrue("Injectet bønne blir ikke kalt for å produsere tekst!",
                   htmlFormatter.harBlittKalt());
    }

    /**
     * Sørg for å injecte en bønne av klassen XmlFormatter i HelloFormattingServiceXml.
     *
     * Man ønsker ikke å måtte endre på HelloFormattingServiceXml hver gang man bytter formaterer. Har formatererene noe
     * til felles som gjør at man kan definere en variabel i HelloFormattingServiceXml som kan holde på en vilkårlig av dem?
     */
    @Test
    public void xmlFormatteringMedBonne() {
        assertEquals("<message to='world'><greet>Hello</greet></message>", helloFormattingServiceXml.getHello("world"));

        assertNotNull("Mangler bønne for XmlFormatter!", applicationContext.getBean(XmlFormatter.class));

        final XmlFormatter xmlFormatter = TestHjelper.hentFeltAvType(helloFormattingServiceXml, XmlFormatter.class);
        assertSame("XmlFormatter er ikke injectet i HelloFormattingServiceXml!",
                   applicationContext.getBean(XmlFormatter.class),
                   xmlFormatter);
        assertTrue("Injectet bønne blir ikke kalt for å produsere tekst!",
                xmlFormatter.harBlittKalt());
        assertTrue("XmlFormatter mangler interface!", TestHjelper.harInterface(XmlFormatter.class));
        assertFalse("HelloFormattingServiceXml har variabel for implementasjon (bør bruker interface)!",
                        TestHjelper.harFeltAvType(helloFormattingServiceXml, XmlFormatter.class));
    }

    /**
     * Sørg for å injecte en bønne av klassen TextFormatter i HelloFormattingServiceXml.
     */
    @Test
    public void textFormatteringMedBonne() {
        assertEquals("Hello, world!", helloFormattingServiceXml.getHello("world"));

        final TextFormatter textFormatter = TestHjelper.hentFeltAvType(helloFormattingServiceXml, TextFormatter.class);
        assertSame("TextFormatter er ikke injectet i HelloFormattingServiceXml!",
                applicationContext.getBean(TextFormatter.class),
                textFormatter);
        assertTrue("Injectet bønne blir ikke kalt for å produsere tekst!",
                textFormatter.harBlittKalt());
        assertTrue("TextFormatter mangler interface!", TestHjelper.harInterface(TextFormatter.class));
        assertFalse("HelloFormattingServiceXml har variabel for implementasjon (bør bruker interface)!",
                        TestHjelper.harFeltAvType(helloFormattingServiceXml, TextFormatter.class));
    }

    /**
     * TODO: Oppgave 3:
     * HelloFormattingService kan nå bare si hallo på ett språk. Derfor ønsker vi å gjøre tekststrengen som holder på
     * "Hello" konfigurerbart, og injecte denne ved hjelp av Spring.
     * Sørg for at testen under blir grønn ved å injecte riktig verdi.
     *
     * Inject verdien "¡Hola" inn i bønne.
     *
     * - For enkelhets skyld, bruk {@link TextFormatter}.
     */
    @Test
    public void holaMundo() {
        assertEquals("¡Hola, mundo!", helloFormattingServiceXml.getHello("mundo"));
    }

    /**
     * TODO: Oppgave 4:
     *
     * Vi ønsker ikke tekststrenger i spring-oppsettet.
     * Bytt derfor ut tekststrengen med verdi fra property-filen "spring.properties".
     *
     * Tips:
     *       - For å referere til en property, bruk: ${navn.pa.property}
     *       - Man må fortelle Spring hvor den finner properties...
     *       - For mac-brukere må man også sette encoding av property-fil til UTF-8 (ved innlesing)
     */
    @Test
    public void bonjourMonde() {
        assertEquals("Bonjour, monde!", helloFormattingServiceXml.getHello("monde"));
    }

    /**
     * TODO: Oppgave 5:
     *
     * Gjør om til constructor-arg injection hvis du brukte property-injection, og vice versa.
     */
}
