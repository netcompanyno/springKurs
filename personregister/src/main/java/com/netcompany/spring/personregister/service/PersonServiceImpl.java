package com.netcompany.spring.personregister.service;

import java.util.List;

import com.netcompany.spring.personregister.domain.Person;
import com.netcompany.spring.personregister.repository.PersonRepository;


/**
 * Standard implementasjon av {@link PersonService}.
 *
 * @author Torbjørn S. Knutsen
 */
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Person hentPerson(final Long id) {
        return personRepository.hentPerson(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> hentAllePersoner() {
        return personRepository.hentAllePersoner();
    }
}
