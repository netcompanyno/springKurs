package com.netcompany.spring.personregister.controller;

import java.util.List;

import javax.inject.Inject;

import com.netcompany.spring.personregister.domain.Person;
import com.netcompany.spring.personregister.service.PersonService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Kontroller for side med liste med {@link Person}er.
 *
 * @author Torbjørn S. Knutsen
 */
@Controller
@RequestMapping("/personer")
public class PersonlisteKontroller {

    @Inject
    private PersonService personService;

    @ModelAttribute("personer")
    public List<Person> hentPersoner() {
        return personService.hentAllePersoner();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String visPersonerSide() {
        return "personer";
    }
}
