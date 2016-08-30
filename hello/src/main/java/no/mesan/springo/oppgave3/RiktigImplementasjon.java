package no.mesan.springo.oppgave3;

import org.springframework.stereotype.Service;

/**
 * Implementasjon som skal brukes.
 *
 * @author Torbjørn S. Knutsen
 */
@Service
public class RiktigImplementasjon implements EtInterface {

    @Override
    public String enMetode() {
        return "RIKTIG!";
    }
}
