package com.netcompany.spring.personregister.repository;

import java.util.List;

import com.netcompany.spring.personregister.domain.Person;

/**
 * Dataoperasjoner tilknyttet {@link Person}
 *
 * @author Torbjørn S. Knutsen
 */
public interface PersonRepository {

    /**
     * Henter {@link Person} med gitt id fra databasen.
     *
     * @param id  id til {@link Person}en man ønsker å hente
     * @return    en {@link Person}
     */
    Person hentPerson(Long id);

    /**
     * Henter alle {@link Person}er i databasen.
     *
     * @return   en liste med {@link Person}er
     */
    List<Person> hentAllePersoner();

    /**
     * Persisterer gitt {@link Person}.
     *
     * @param person  {@link Person} som skal persisteres
     */
    void lagrePerson(Person person);
}
