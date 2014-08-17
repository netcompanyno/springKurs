package no.mesan.car.domain;

import java.util.List;

/**
 * Implementasjon av CarRepository mot database.
 * TODO Ikke implementert (trengs ikke for testen)
 */
public class DbCarRepository implements CarRepository {

    @Override
    public List<Car> findAll() {
        throw new UnsupportedOperationException("findAll");
    }

    @Override
    public List<Car> findNoImportTax() {
        throw new UnsupportedOperationException("findNoImportTax");
    }

    @Override
    public void update(final Car car) {
        throw new UnsupportedOperationException("update");
    }

}
