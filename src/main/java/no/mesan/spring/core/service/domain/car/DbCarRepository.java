package no.mesan.spring.core.service.domain.car;

import java.util.List;

import org.springframework.stereotype.Repository;

import no.mesan.spring.core.domain.car.Car;
import no.mesan.spring.core.domain.car.CarRepository;


/**
 * Implementasjon av CarRepository mot database.
 * TODO Ikke implementert
 */
@Repository("stdCarRepository")
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
