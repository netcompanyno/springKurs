package com.netcompany.spring.felles;

import com.netcompany.spring.felles.ikke.ror.NoeSomBrukesForASjekkeOppgaver;

/**
 * Formatterer beskjeder som tekst.
 *
 * Denne filen kan endres!
 */
public class TextFormatter extends NoeSomBrukesForASjekkeOppgaver {

    public String format(final String greet, final String recipient) {
        metodeKalt();
        return greet + ", " + recipient + "!";
    }
}
