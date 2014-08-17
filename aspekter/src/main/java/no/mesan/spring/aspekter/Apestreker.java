package no.mesan.spring.aspekter;

/**
 * Klasse som skal bli offer for apestreker.
 *
 * @author Torbjørn S. Knutsen
 */
public class Apestreker {

    public String enString() {
        return "Eple";
    }

    public Integer enInteger() {
        return 42;
    }

    public void enException() {
        throw new RuntimeException("Apekatter ftw!");
    }

}
