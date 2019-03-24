package com.netcompany.spring.personregister.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.netcompany.spring.personregister.domain.Person;

import org.apache.commons.lang3.Validate;

/**
 * JPA-implementasjon av {@link PersonRepository}.
 *
 * @author Torbjørn S. Knutsen
 */
public class PersonRepositoryJPA implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public Person hentPerson(final Long id) {
        Validate.notNull(id, "Kan ikke hente person når angitt id er null!");

        return em.find(Person.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> hentAllePersoner() {
        final TypedQuery<Person> query =
                em.createQuery("select p from Person p", Person.class);

        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void lagrePerson(final Person person) {
        Validate.notNull(person, "Kan ikke lagre person når person er null!");

        em.persist(person);
        em.flush();
    }
}
