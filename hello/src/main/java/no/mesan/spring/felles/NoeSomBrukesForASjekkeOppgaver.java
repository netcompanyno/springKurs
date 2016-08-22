package no.mesan.spring.felles;

/**
 * Felles superklasse for formatterene.
 * Ikke nødvendig å endre noe.
 * http://tinyurl.com/hqowup9
 */
public abstract class NoeSomBrukesForASjekkeOppgaver {

    //Dette er egentlig fyfy da det er tilstand, men har det med for å få sjekket at gaven er løst
    private boolean harBlittKalt = false;

    protected void metodeKalt() {
        harBlittKalt = true;
    }

    public boolean harBlittKalt() {
        return harBlittKalt;
    }
}
