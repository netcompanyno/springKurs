package com.netcompany.spring.personregister.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.netcompany.spring.personregister.domain.Person;
import com.netcompany.spring.personregister.util.DatoHjelper;

/**
 * Dummy-implementasjon av {@link PersonRepository}.
 *
 * @author Torbjørn S. Knutsen
 */
public class PersonRepositoryDummy implements PersonRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public Person hentPerson(final Long id) {
        return new Person("Torbjørn", "Knutsen", "97714022", new Date(), "torbjornk@mesan.no");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> hentAllePersoner() {
        final Person person1 = new Person("Torbjørn", "Knutsen", "97714022", DatoHjelper.hentDato(31, 8, 1986), "torbjornk@mesan.no");
        final Person person2 = new Person("Vidar", "Berentsen", "12345678", new Date(), "vidarb@mesan.no");

        person1.setId(1L);
        person2.setId(2L);

        final List<Person> personer = new ArrayList<>();

        personer.add(person1);
        personer.add(person2);

        return personer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void lagrePerson(final Person person) {
        throw new UnsupportedOperationException("Kan ikke lagre i dummy-implementasjon!");
    }
}
