package com.netcompany.spring.aspekter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotasjon man kan legge på en metode for å la apekatter leke med den.
 *
 * OBS! Brukes på eget ansvar!
 *
 * @author Torbjørn S. Knutsen
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Apekatt {

}
