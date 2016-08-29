package no.mesan.spring.oppgave3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Tester av {@link EnService}.
 *
 * @author Torbjørn S. Knutsen
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Oppgave3Config.class)
public class EnServiceTest {

    @Lazy
    @Inject
    private EnService enService;

    /**
     * Få denne testen til å kjøre grønt, ved KUN bruk av @Lazy og @Primary. Ingen andre kodeendringer tillatt!
     */
    @Test
    public void springOppsettSkalFungere() {
        assertEquals("RIKTIG!", enService.gjorNoe());
    }
}
