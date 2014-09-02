package no.mesan.utils;


/**
 * Misc static utility functions on Class etc.
 *
 * @author lre, Mesan AS
 */
public final class ClassUtils {

    /** Full path with trailing slash, up to, but not including, class name. */
    public static String pathToClass(final Class clazz) {
        return clazz.getName()
                    .replaceAll("[.][^.]+$", "")
                    .replaceAll("[.]", "/")
               + "/";
    }
}
