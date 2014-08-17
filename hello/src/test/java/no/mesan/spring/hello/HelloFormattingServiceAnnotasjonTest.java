package no.mesan.spring.hello;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import no.mesan.spring.hello.annotasjon.HelloFormattingServiceAnnotasjon;
import no.mesan.spring.hello.felles.HtmlFormatter;

/**
 * Andre sett med oppgaver, konfigurasjon med annotasjoner.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-annotasjon.xml")
public class HelloFormattingServiceAnnotasjonTest {

    @Inject
    private HelloFormattingServiceAnnotasjon helloFormattingServiceAnnotasjon;

    /**
     * Oppgave 1:
     * Legg på nødvendige annotasjoner og xml-oppsett for å få testen til å kjøre.
     *
     * Tips:
     *      - Spring må vite hvor den skal lete..
     *      - Spring må kunne kjenne igjen klassene som det skal lages bønner av..
     */
    @Test
    public void skalFinneVedHjelpAvComponentScan() {
        assertNotNull(helloFormattingServiceAnnotasjon);
    }

    /**
     * Oppgave 2:
     * Bruk annotasjoner til å injecte {@link HtmlFormatter} i stedet for å new-e.
     */
    @Test
    public void sePaUtskrift() {
        System.out.println(helloFormattingServiceAnnotasjon.getHello("world"));
    }

    @Test
    public void htmlFormatteringMedBonne() {
        assertEquals("<b>Hello, <i>world</i>!</b>", helloFormattingServiceAnnotasjon.getHello("world"));
    }

    /**
     * Tips:
     *      - Bruk @Named for å injecte en bestemt implementasjon av Formatter-interface.
     */
    @Test
    public void xmlFormatteringMedBonne() {
        assertEquals("<message to='world'><greet>Hello</greet></message>",
                     helloFormattingServiceAnnotasjon.getHello("world"));
    }

    @Test
    public void textFormatteringMedBonne() {
        assertEquals("Hello, world!", helloFormattingServiceAnnotasjon.getHello("world"));
    }

    /**
     * Oppgave 3:
     * Vi ønsker også her å kunne si hallo på flere språk. Value-inject verdi fra spring.properties.
     *
     * Tips:
     *     - Bruk @Value til å inject String-verdier
     *     - For å injecte verdi fra property-fil, bruk formatet {navn.pa.property}
     *     - Spring må vite hvor properties ligger..
     */
    @Test
    public void holaMundo() {
        assertEquals("¡Hola, mundo!", helloFormattingServiceAnnotasjon.getHello("mundo"));
    }

    /**
     * Oppgave 4 (bonus):
     *
     * Prøv å blande annotasjoner og xml, ved å fjerne annotasjoner på fra *Formatter-klassene og definere bønner for
     * disse vha xml.
     */
}
