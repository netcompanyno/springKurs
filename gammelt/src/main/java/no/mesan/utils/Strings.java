package no.mesan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Hjelperutiner for strenger.
 *
 * @author lre
 */
public final class Strings {

    /** Formatstreng for dato+tid. */
    public static final String DATETIME_FORMAT= "dd.MM.yyyy HH:mm";

    /** Skjult constructor. */
    private Strings() { /*EMPTY*/ }

    /**
     * Sjekker om en streng er null/blank.
     *
     * @param s Streng som skal sjekkes
     * @return <code>true</code> hvis det i høyden er blanke tegn og intet annet
     */
    public static boolean isEmpty(final String s) {
        return (s == null || s.length()==0 || s.trim().length() == 0);
    }

    /**
     * Sett streng i enkeltfnutter.
     *
     * @param o Inputstreng, gjøres om til streng hvis annen objekttype
     * @return Inputstrengen omsluttet av "''", null håndteres som tom streng
     */
    public static String fnutt(final Object o) {
        return "'" + ((o==null)? "" : o.toString()) + "'";
    }

    /**
     * Slå sammen strenger til én lang streng.
     *
     * @param separator Hvordan delene skal skilles av
     * @param args Alt som skal skjøtes -- objekter konverteres
     *             med toString
     * @return Herlig røre (<code>null</code> hvis ingen input)
     */
    public static String concat(final String separator, final Object... args) {
        if ( args==null ) {
            return null;
        }
        if ( args.length==1 ) { // Optimaliserer på enkeltargument
            return String.valueOf(args[0]);
        }
        final StringBuilder buf= new StringBuilder();
        int rest= args.length;
        for (final Object object : args) {
            buf.append(object);
            rest--;
            if ( rest> 0 ) {
                buf.append(separator);
            }
        }
        return buf.toString();
    }

    /**
     * Formaterer en gitt dato på lesbar form.
     *
     * @param date Dato som skal formateres
     * @return Formatert streng
     */
    public static String dateTimeReadable(final Date date) {
        return new SimpleDateFormat(DATETIME_FORMAT).format(date);
    }

    /**
     * Returner en streng uten overflødige blanke (foran/bak), som samtidig
     * håndterer <code>null</code> som tom streng.
     *
     * @param s Original
     * @return Konvertert
     */
    public static String minimal(final String s) {
        return Strings.safe(s).trim().replaceFirst("^\\s", "");

    }

    /**
     * Returner input, men tom streng for <code>null</code>.
     *
     * @param s Original
     * @return s, men "" for null
     */
    public static String safe(final String s) {
        return s==null? "" : s;
    }
}
