package no.mesan.springo.oppgave3;

import org.springframework.stereotype.Service;

/**
 * Implementasjon som ikke skal brukes, men som fortsatt må ha @Service.
 *
 * @author Torbjørn S. Knutsen
 */
@Service
public class FeilImplementasjon implements EtInterface {

    @Override
    public String enMetode() {
        return "FEIL!";
    }
}
