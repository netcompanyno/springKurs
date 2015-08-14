package no.mesan.spring.hello.util;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author Torbjørn S. Knutsen
 */
public class TestHjelper {
    public static <T> T hentFeltAvType(final Object objekt, final Class klasse) {
        final Field felt = hentFelt(objekt, klasse);

        if (felt == null) {
            return null;
        }

        return (T) ReflectionUtils.getField(felt, objekt);
    }

    private static Field hentFelt(final Object objekt, final Class klasse) {
        return hentFelt(objekt.getClass(), klasse);
    }

    private static Field hentFelt(final Class klasseForObjekt, final Class klasseViLeterEtter) {
        if (klasseViLeterEtter.getInterfaces().length == 1) {
            return hentFeltViaNavnEllerKlasse(klasseForObjekt, null, klasseViLeterEtter.getInterfaces()[0]);
        }

        return hentFeltViaNavnEllerKlasse(klasseForObjekt, null, klasseViLeterEtter);
    }

    private static Field hentFeltViaNavnEllerKlasse(final Class klasse, final String feltnavn, final Class type) {
        final Field felt = ReflectionUtils.findField(klasse, feltnavn, type);
        if(felt == null) {
            return null;
        } else {
            felt.setAccessible(true);
            return felt;
        }
    }

    public static boolean harInterface(final Class klasse) {
        return klasse.getInterfaces().length > 0;
    }

}
