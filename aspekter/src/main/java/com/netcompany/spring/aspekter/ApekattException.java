package com.netcompany.spring.aspekter;

/**
 * Apete exception.
 *
 * @author Torbjørn S. Knutsen
 */
public class ApekattException extends RuntimeException {
    public ApekattException(final Exception e) {
        super(e);
    }
}
