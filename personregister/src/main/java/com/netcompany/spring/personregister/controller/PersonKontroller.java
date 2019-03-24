package com.netcompany.spring.personregister.controller;

import javax.inject.Inject;

import com.netcompany.spring.personregister.domain.Person;
import com.netcompany.spring.personregister.service.PersonService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Kontroller for siden for visning av en {@link Person}.
 *
 * @author Torbjørn S. Knutsen
 */
@Controller
@RequestMapping("/person/{personId}")
public class PersonKontroller {

    @Inject
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String visPersonSide() {
        return "person";
    }

    @ModelAttribute("person")
    public Person hentPerson(@PathVariable final Long personId) {
        return personService.hentPerson(personId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String lagrePerson(final Person person,
                              final Errors errors,
                              final ModelMap modell) {
        return "person";
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.setAllowedFields();
    }

}
