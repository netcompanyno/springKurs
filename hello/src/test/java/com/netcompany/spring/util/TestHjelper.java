package com.netcompany.spring.util;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author Torbj�rn S. Knutsen
 */
public class TestHjelper {
    public static <T> T hentFeltAvType(final Object objekt, final Class klasse) {
        final Field felt = hentFelt(objekt, klasse);

        if (felt == null) {
            return null;
        }

        if(AopUtils.isAopProxy(objekt) && objekt instanceof Advised) {
            Object target = null;
            try {
                target = ((Advised) objekt).getTargetSource().getTarget();
            } catch (Exception e) {
                throw new RuntimeException("Klarte ikke deproxy av Spring-b�nne!");
            }
            return (T) ReflectionUtils.getField(felt, target);
        }

        return (T) ReflectionUtils.getField(felt, objekt);
    }

    private static Field hentFelt(final Object objekt, final Class klasse) {
        return hentFelt(objekt.getClass(), klasse);
    }

    private static Field hentFelt(final Class klasseForObjekt, final Class klasseViLeterEtter) {
        Field ret = null;
        if (klasseViLeterEtter.getInterfaces().length == 1) {
            ret = hentFeltViaNavnEllerKlasse(klasseForObjekt, null, klasseViLeterEtter.getInterfaces()[0]);
        }

        if (ret != null) {
            return ret;
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

    public static boolean harFeltAvType(final Object object, final Class type) {
        return hentFeltViaNavnEllerKlasse(object.getClass(), null, type) != null;
    }
}
