package com.netcompany.spring.personregister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Kontroller som mappes til roten av spring servleten, dvs <code>/side/</code>,
 * slik at den kan videresende til forsiden på <code>/side/forside</code>.
 *
 * @author Trond Marius Øvstetun
 */
@Controller
@RequestMapping("/")
public class RotKontroller {
    public static final String URL = "/side";
    public static final String REDIRECT = "redirect:";

    /**
     * Videresender til forsiden.
     *
     * @return URL til forsiden.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String visPersoner() {
        return REDIRECT + "/personer";
    }
}
