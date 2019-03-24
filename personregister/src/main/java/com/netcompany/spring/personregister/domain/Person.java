package com.netcompany.spring.personregister.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Representasjon av en person.
 *
 * @author Torbjørn S. Knutsen
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String fornavn;

    private String etternavn;

    private String telefonnummer;

    private Date fodselsdato;

    private String epostadresse;

    @SuppressWarnings("unused")
    protected Person() {
        //Hibernate sin konstrukør
    }

    public Person(final String fornavn,
                  final String etternavn,
                  final String telefonnummer,
                  final Date fodselsdato,
                  final String epostadresse) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonnummer = telefonnummer;
        this.fodselsdato = fodselsdato;
        this.epostadresse = epostadresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(final String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(final String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(final String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Date getFodselsdato() {
        return fodselsdato;
    }

    public void setFodselsdato(final Date fodselsdato) {
        this.fodselsdato = fodselsdato;
    }

    public String getEpostadresse() {
        return epostadresse;
    }

    public void setEpostadresse(final String epostadresse) {
        this.epostadresse = epostadresse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("fornavn", fornavn)
                .append("etternavn", etternavn)
                .append("telefonnummer", telefonnummer)
                .append("fodselsdato", fodselsdato)
                .append("epostadresse", epostadresse)
                .toString();
    }
}
