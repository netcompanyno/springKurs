package com.netcompany.spring.personregister.service;

import java.util.List;

import com.netcompany.spring.personregister.domain.Person;
import com.netcompany.spring.personregister.repository.PersonRepository;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Standard implementasjon av {@link PersonService}.
 *
 * @author Torbjørn S. Knutsen
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Inject
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

    @PostConstruct
    public void lagPersoner() {
        personRepository.lagrePerson(new Person("Torbjørn",
                                                "Knutsen",
                                                "97714022",
                                                new LocalDate(1986, 8, 31).toDate(),
                                                "torbjornk@netcompany.com"));
        //TODO: Lagre deg selv her?
    }
}
