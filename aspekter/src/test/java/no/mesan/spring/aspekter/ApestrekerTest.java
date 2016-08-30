package no.mesan.spring.aspekter;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-aop.xml")
public class ApestrekerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Inject
    private Apestreker apestreker;

    @Test
    public void apekattAspektSkalDobleAlleReturnerteTall() {
        assertEquals(84, apestreker.enInteger().intValue());

        assertEquals(42, new Apestreker().enInteger().intValue());
    }

    @Test
    public void apekattAspektSkalBytteUtAlleReturnerteStringerMedBanan() {
        assertEquals("Banan", apestreker.enString());

        assertEquals("Eple", new Apestreker().enString());
    }

    @Test
    public void apekattAspektSkalWrappeAlleExceptionsIApekattException() {
        expectedException.expect(ApekattException.class);
        expectedException.expectMessage("Apekatter ftw!");

        apestreker.enException();
    }
}
