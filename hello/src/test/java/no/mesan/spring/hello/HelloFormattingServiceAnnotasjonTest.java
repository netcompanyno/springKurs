package no.mesan.spring.hello;

import static org.junit.Assert.*;

import javax.inject.Inject;

import no.mesan.spring.hello.felles.TextFormatter;
import no.mesan.spring.hello.felles.XmlFormatter;
import no.mesan.spring.hello.util.TestHjelper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import no.mesan.spring.hello.annotasjon.HelloFormattingServiceAnnotasjon;
import no.mesan.spring.hello.felles.HtmlFormatter;

/**
 * Andre sett med oppgaver, konfigurasjon med annotasjoner.
 *
 * Kjør èn og èn test. Det er ikke meningen at flere tester skal kjøres samtidig.
 *
 * OBS! Det er ikke lov å endre denne filen! (Bortsett fra å fjerne @Ignore for å få kjørt testene..)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-annotasjon.xml")
public class HelloFormattingServiceAnnotasjonTest {

    @Inject
    private HelloFormattingServiceAnnotasjon helloFormattingServiceAnnotasjon;

    @Inject
    private ApplicationContext applicationContext;

    /**
     * TODO: Oppgave 1:
     * Legg på nødvendige annotasjoner og xml-oppsett for å få testen til å kjøre.
     *
     * Tips:
     *      - Spring må vite hvor den skal lete..
     *      - Spring må kunne kjenne igjen klassene som det skal lages bønner av..
     */
    @Test
    @Ignore
    public void skalFinneVedHjelpAvComponentScan() {
        assertNotNull("Mangler bønne for HelloFormattingServiceAnnotasjon!", helloFormattingServiceAnnotasjon);
    }

    /**
     * TODO: Oppgave 2:
     * Bruk annotasjoner til å injecte {@link HtmlFormatter} i stedet for å new-e.
     */
    @Test
    @Ignore
    public void sePaUtskrift() {
        System.out.println(helloFormattingServiceAnnotasjon.getHello("world"));
    }

    @Test
    @Ignore
    public void htmlFormatteringMedBonne() {
        assertEquals("<b>Hello, <i>world</i>!</b>", helloFormattingServiceAnnotasjon.getHello("world"));

        assertNotNull("Mangler bønne for HtmlFormatter!", applicationContext.getBean(HtmlFormatter.class));
        final HtmlFormatter htmlFormatter = TestHjelper.hentFeltAvType(helloFormattingServiceAnnotasjon,
                                                                       HtmlFormatter.class);
        assertSame("HtmlFormatter er ikke injectet i HelloFormattingServiceXml!",
                   applicationContext.getBean(HtmlFormatter.class),
                   htmlFormatter);
        assertTrue("Injectet bønne blir ikke kalt for å produsere tekst!",
                   htmlFormatter.harBlittKalt);
    }

    /**
     * Tips:
     *      - Bruk @Named for å injecte en bestemt implementasjon av Formatter-interface.
     */
    @Test
    @Ignore
    public void xmlFormatteringMedBonne() {
        assertEquals("<message to='world'><greet>Hello</greet></message>",
                     helloFormattingServiceAnnotasjon.getHello("world"));

        assertNotNull("Mangler bønne for XmlFormatter!", applicationContext.getBean(XmlFormatter.class));

        final XmlFormatter xmlFormatter = TestHjelper.hentFeltAvType(helloFormattingServiceAnnotasjon,
                                                                     XmlFormatter.class);
        assertSame("XmlFormatter er ikke injectet i HelloFormattingServiceXml!",
                   applicationContext.getBean(XmlFormatter.class),
                   xmlFormatter);
        assertTrue("Injectet bønne blir ikke kalt for å produsere tekst!",
                xmlFormatter.harBlittKalt);
    }

    @Test
    @Ignore
    public void textFormatteringMedBonne() {
        assertEquals("Hello, world!", helloFormattingServiceAnnotasjon.getHello("world"));

        final TextFormatter textFormatter = TestHjelper.hentFeltAvType(helloFormattingServiceAnnotasjon,
                                                                       TextFormatter.class);
        assertSame("TextFormatter er ikke injectet i HelloFormattingServiceXml!",
                   applicationContext.getBean(TextFormatter.class),
                   textFormatter);
        assertTrue("Injectet bønne blir ikke kalt for å produsere tekst!",
                   textFormatter.harBlittKalt);
    }

    /**
     * TODO: Oppgave 3:
     * Vi ønsker også her å kunne si hallo på flere språk. Value-inject verdi fra spring.properties.
     *
     * Tips:
     *     - Bruk @Value til å inject String-verdier
     *     - For å injecte verdi fra property-fil, bruk formatet ${navn.pa.property}
     *     - Spring må vite hvor properties ligger..
     */
    @Test
    @Ignore
    public void holaMundo() {
        assertEquals("¡Hola, mundo!", helloFormattingServiceAnnotasjon.getHello("mundo"));
    }

    /**
     * TODO: Oppgave 4:
     *
     * Prøv å blande annotasjoner og xml, ved å fjerne annotasjoner på fra *Formatter-klassene og definere bønner for
     * disse vha xml.
     */
}
