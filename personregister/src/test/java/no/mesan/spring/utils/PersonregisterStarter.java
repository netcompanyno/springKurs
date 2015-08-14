package no.mesan.spring.utils;

/**
 *
 * @author Torbjørn S. Knutsen
 */
public class PersonregisterStarter extends AbstractJettyStarter {

    //OBS! Mac-brukere må angi full mappesti som parameter nummer 2 her..
    private PersonregisterStarter() {
        super(8080, "src/main/webapp", "/personregister");
    }

    public static void main(final String... args) throws Exception {
        new PersonregisterStarter().start();
    }

    @Override
    protected void setupProperties() {

    }
}
