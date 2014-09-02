package no.mesan.spring.core.domain.car;

import java.util.List;


/** Tilgang til biler... */
public interface CarRepository {

    /**
     * Alle biler!
     * @return Liste av biler, aldri <code>null</code>
     */
    List<Car> findAll();

    /**
     * Liste av biler som ikke har betalt engangsavgift.
     * @return Liste av biler, aldri <code>null</code>
     */
    List<Car> findNoImportTax();

    /**
     * Oppdater en forekomst.
     *
     * @param car Skal oppdateres
     */
    void update(Car car);
}
