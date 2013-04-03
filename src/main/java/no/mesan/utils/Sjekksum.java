package no.mesan.utils;


/**
 * Kontroll av sjekksummer for fødsels- og organisasjonsnummer.
 *
 * @author lars.reed@mesan.no
 */
public final class Sjekksum {

    private Sjekksum() { /*EMPTY*/ }

    /** Lengden på gyldig organisasjonsnummer. */
    private static final int LENGDE_ORGNR= 9;

    /** Lengden på gyldig fødselsnummer. */
    private static final int LENGDE_FNR= 11;

    /** De magiske vekttallene for beregning av sjekksum på orgnr. */
    private static final int[] VEKTTALL_ORGNR= { 3, 2, 7, 6, 5, 4, 3, 2 };

    /** De magiske vekttallene for beregning av sjekksum på fnr. */
    private static final int[][] VEKTTALL_FNR= {
        { 3, 7, 6, 1, 8, 9, 4, 5, 2 },
        { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 }
    };

    /**
     * Sjekker om fødselsnummeret har riktig format.
     *
     * @param kundeNr Fødselsnummer
     * @return <code>true</code> hvis gyldig format
     */
    public static boolean gyldigFnr(final String kundeNr) {
        if ( !sjekkRiktigLengde(kundeNr, LENGDE_FNR) ) {
            return false;
        }
        final int[] fnr= string2intArr(kundeNr.trim());
        final int delsum1= mod11(sumProduct(VEKTTALL_FNR[0].length-1, VEKTTALL_FNR[0], fnr));
        final int delsum2= mod11(sumProduct(VEKTTALL_FNR[1].length-1, VEKTTALL_FNR[1], fnr));
        return delsum1==fnr[LENGDE_FNR-2]
            && delsum2==fnr[LENGDE_FNR-1];
    }

    /**
     * Sjekker om organisasjonsnummeret har gyldig format.
     *
     * @param kundeNr Potensielt org.nr.
     * @return boolean <code>true</code> hvis ikke tomt og gyldig format
     */
    public static boolean gyldigOrgnr(final String kundeNr) {
        if ( !sjekkRiktigLengde(kundeNr, LENGDE_ORGNR)) {
            return false;
        }
        final int[] orgNr= string2intArr(kundeNr.trim());
        final int resultat= mod11(sumProduct(VEKTTALL_ORGNR.length-1,
                                       VEKTTALL_ORGNR,
                                       orgNr));
        return resultat == orgNr[LENGDE_ORGNR-1];
    }


    private static boolean sjekkRiktigLengde(final String kundeNr, final int lengde) {
        return kundeNr != null
            && kundeNr.trim().length() == lengde;
    }

    /** Modulus 11 sjekksiffer. */
    private static int mod11(final int verdi) {
        final int nyVerdi= 11 - (verdi % 11);
        return (nyVerdi==11)? 0 : nyVerdi;
    }

    /** Konverter tallstreng til tallarray. */
    private static int[] string2intArr(final String kundeNr) {
        final int length= kundeNr.length();
        final int[] result= new int[length];
        for (int i= 0; i < length; i++) {
            result[i]= Character.digit(kundeNr.charAt(i), 10);
        }
        return result;
    }

    /** Beregn summen av produktene i tilsvarende elementer i de 2 arrayene. */
    private static int sumProduct(final int index, final int[] arr1, final int[] arr2) {
        if ( index < 0 ) return 0;
        return (arr1[index] * arr2[index]) + sumProduct(index-1, arr1, arr2);
    }
}
