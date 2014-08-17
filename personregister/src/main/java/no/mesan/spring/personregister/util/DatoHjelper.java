package no.mesan.spring.personregister.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.Validate;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/**
 * Klasse med praktiske metoder for dato håndtering.
 *
 * @author Christian Ihle
 */
public final class DatoHjelper {

    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String EVURDERING_DATO_FORMAT = "dd.MM.yyyy";
    public static final String DATO_OG_KLOKKESLETT_FORMAT = "dd.MM.yyyy HH:mm:ss";

    private static final String DATO_MAA_VARE_GITT = "Dato må være gitt.";

    private DatoHjelper() {

    }

    /**
     * Henter dato akkurat nå.
     *
     * @return Dato som representerer dato/tid akkurat nå.
     */
    public static Date hentDatoNaa() {
        return new Date();
    }

    /**
     * Henter en dato med gitt antall sekunder inn i fremtiden.
     *
     * @param sekunder Antall sekunder inn i fremtiden det ønskes dato for.
     * @return Dato-objekt for den tiden som ønskes.
     */
    public static Date hentDatoIFremtiden(final int sekunder) {
        final Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.SECOND, sekunder);

        return calendar.getTime();
    }

    /**
     * Konverterer angitt dato som {@link Date} til en string i ønsket format.
     *
     * @param dato   Datoen som skal konverteres.
     * @param format Datoformat. Se {@link SimpleDateFormat}.
     * @return Datoen i string format.
     */
    public static String hentDatoSomString(final Date dato, final String format) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(dato);
    }

    /**
     * Konverterer angitt dato i string format til et {@link Date} objekt.
     *
     * @param dato   Datoen som skal konverteres.
     * @param format Formatet som skal brukes for å parse datoen i string format.
     * @return Dato objekt for angitt string dato.
     */
    public static Date hentDato(final String dato, final String format) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(dato);
        } catch (final ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Henter en dato basert på dag, måned og år. Tidspunkt settes til 0.
     *
     * @param dag   Dag, mellom 1 og 31.
     * @param maned Måned mellom 1 og 12.
     * @param ar    År, fra 1 og oppover.
     * @return Dato objekt for angitt tall dato.
     */
    public static Date hentDato(final Integer dag, final Integer maned, final Integer ar) {
        Validate.notNull(dag, "Dag kan ikke være null");
        Validate.notNull(maned, "Måned kan ikke være null");
        Validate.notNull(ar, "År kan ikke være null");
        Validate.isTrue(ar > 0, "År kan ikke være 0 eller mindre");

        final LocalDate dato = new LocalDate()
                .withYear(ar)
                .withMonthOfYear(maned)
                .withDayOfMonth(dag);

        return dato.toDateTimeAtStartOfDay().toDate();
    }

    /**
     * Konverterer et årstall til et LocalDateTime objekt med dato 1. jan.
     *
     * @param ar Årstall.
     * @return LocalDateTime objekt med dato 1. jan.
     */
    public static LocalDateTime konverterArTilLocalDateTime(final Integer ar) {
        return new LocalDateTime(ar.toString());
    }

    /**
     * Konverterer et LocalDateTime objekt til et Date objekt.
     *
     * @param localDateTimeObject LocalDateTime objekt.
     * @return Date objekt.
     */
    public static Date konverterLocalDateTimeTilDate(final LocalDateTime localDateTimeObject) {
        return localDateTimeObject.toDateTime().toDate();
    }

    /**
     * Konverterer et Date objekt til et årstall.
     *
     * @param dato Date objekt.
     * @return Integer årstall for angitt Date dato.
     */
    public static Integer konverterDateTilAr(final Date dato) {
        Validate.notNull(dato, DATO_MAA_VARE_GITT);

        final LocalDateTime t = new LocalDateTime(dato);
        return t.getYear();
    }

    /**
     * Konverterer inngitt dato til et tall som representerer månden.
     *
     * @param dato Datoen som skal konverteres
     * @return månedens nummer
     */
    public static Integer konverterDateTilMnd(final Date dato) {
        Validate.notNull(dato, DATO_MAA_VARE_GITT);

        final LocalDateTime t = new LocalDateTime(dato);
        return t.getMonthOfYear();
    }

    /**
     * Konverterer inngitt dato til dagens nr. månden.
     *
     * @param dato Datoen som skal konverteres
     * @return dagens nr. måneden
     */
    public static Integer konverterDateTilDag(final Date dato) {
        Validate.notNull(dato, DATO_MAA_VARE_GITT);

        final LocalDateTime t = new LocalDateTime(dato);
        return t.getDayOfMonth();
    }

    /**
     * Konverterer et årstall til et Date objekt med dato 1. jan.
     *
     * @param arstall Årstall.
     * @return Date dato objekt for angitt årstall.
     */
    public static Date konverterArTilDate(final Integer arstall) {
        final LocalDateTime localDateTimeObject = new LocalDateTime(arstall.toString());
        return localDateTimeObject.toLocalDate().toDateMidnight().toDate();
    }


    /**
     * Henter inneværende år.
     *
     * @return Integer-objekt inneholdende inneværende år
     */
    public static Integer hentInnevarendeAar() {
        return new LocalDateTime().getYear();
    }

    /**
     * Tar inn en dato og returnerer et Date-objekt med samme dato-del, men tidspunktet satt til 23:59:59.0.
     *
     * @param dato dato som danner utgangspunktet
     * @return dato med tidspunktet satt til helt slutt på dagen
     */
    public static Date hentDatoPaaSluttenAvDagen(final Date dato) {
        Validate.notNull(dato, DATO_MAA_VARE_GITT);

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(dato);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        // Setter til 0 siden MSSQL sliter med konsistent håndtering av millisekunder
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * Tar inn en dato og returnerer et Date-objekt med samme dato-del, men tidspunktet satt til 00:00:00.000.
     *
     * @param dato dato som danner utgangspunktet
     * @return dato med tidspunktet satt til helt først på dagen
     */
    public static Date hentDatoPaaStartenAvDagen(final Date dato) {
        Validate.notNull(dato, DATO_MAA_VARE_GITT);

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(dato);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * Henter et dato-objekt slik det bør være i en fradato, dvs 1. januar kl 00:00:00 i angitt år.
     *
     * @param fraAr Fra-året som skal returneres som dato.
     * @return 01.01.fraÅr kl 00:00:00.
     */
    public static Date hentFraDatoForAr(final Integer fraAr) {
        return hentDatoPaaStartenAvDagen(hentDato(1, 1, fraAr));
    }

    /**
     * Henter et dato-objekt slik det bør være i en tildato, dvs 31. desember kl 23:59:59 i angitt år.
     *
     * @param tilAr Til-året som skal returneres som dato.
     * @return 31.12.tilÅr kl 23:59:59.
     */
    public static Date hentTilDatoForAr(final Integer tilAr) {
        return hentDatoPaaSluttenAvDagen(hentDato(31, 12, tilAr));
    }

    /**
     * Returnerer den av datoene som er senest.
     *
     * @param dato1 Dato 1. Kan være <code>null</code>.
     * @param dato2 Dato 2. Kan være <code>null</code>.
     * @return Den seneste av dato 1 og dato 2, eller <code>null</code> hvis begge er <code>null</code>.
     */
    public static Date hentSenesteAv(final Date dato1, final Date dato2) {
        if (dato1 == null) {
            return dato2;
        }

        if (dato2 == null) {
            return dato1;
        }

        if (dato1.after(dato2)) {
            return dato1;
        }

        return dato2;
    }

    /**
     * Returnerer den av datoene som er tidligst.
     *
     * @param dato1 Dato 1. Kan være <code>null</code>.
     * @param dato2 Dato 2. Kan være <code>null</code>.
     * @return Den tidligste av dato 1 og dato 2, eller <code>null</code> hvis begge er <code>null</code>.
     */
    public static Date hentTidligsteAv(final Date dato1, final Date dato2) {
        if (dato1 == null) {
            return dato2;
        }

        if (dato2 == null) {
            return dato1;
        }

        if (dato1.before(dato2)) {
            return dato1;
        }

        return dato2;
    }
}
