package no.mesan.spring.oppgave3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service som egentlig ikke brukes, men som likevel skal være annotert med @Service.
 *
 * @author Torbjørn S. Knutsen
 */
@Service
public class NoeSomIkkeBrukes {

    @Value("${noe.Som.Ikke.Skal.Eksistere}")
    private String noeTull;

}
