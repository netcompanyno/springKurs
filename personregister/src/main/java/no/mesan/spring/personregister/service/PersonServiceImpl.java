package no.mesan.spring.personregister.service;

import java.util.List;

import no.mesan.spring.personregister.domain.Person;
import no.mesan.spring.personregister.repository.PersonRepository;


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
