package com.netcompany.spring.oppgave3;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * En service..
 *
 * @author Torbjørn S. Knutsen
 */
@Service
public class EnService {

    @Inject
    private EtInterface etInterface;

    public String gjorNoe() {
        return etInterface.enMetode();
    }

}
