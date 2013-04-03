package no.mesan.spring.core.service.domain.car;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import no.mesan.spring.core.domain.car.Car;
import no.mesan.spring.core.domain.car.CarRepository;
import no.mesan.spring.core.domain.car.Engine;


/**
 * Mockutgave av {@link CarRepository}.
 */
@Repository
public class TestCarRepository implements CarRepository {

    private static final String CAR_SPECS[]= {
        "VW      | Passat     | 2010 | 2130 | 149.2",
        "VW      | Passat     | 2009 | 2130 | 149.2",
        "VW      | Golf       | 2010 | 2030 | 201",
        "Ferrari | 458 Italia | 2010 | 1380 | 420",
        "Toyota  | RAV4       | 2007 | 2190 | 130",
        "Junk    | Yard       | 1963 | 2420 | 48",
        "Slow    | Starter    | 2009 | 1012 | -",
        "Future  | Legend     | 3033 | 100  | 32000",
    };

    private static final List<Car> CARS= new LinkedList<Car>();

    static {
        for (int i= 0; i < CAR_SPECS.length; i++) {
            final String carSpec= CAR_SPECS[i];
            final Car car= createCar(i+1, carSpec);
            CARS.add(car);
        }
    }

    /**
     * Lag bilforekomst fra streng.
     *
     * @param id Ønsket ID
     * @param carSpec Format "Fabrikat|Modell|År|Vekt|Ytelse"
     *        (ytelse kan være "-" for å utelate motor)
     * @return Bil, kanskje med motor
     */
    public static Car createCar(final int id,
                                final String carSpec) {
        final String[] fields= carSpec.split(" *[|] *");
        final Car car= new Car();
        car.setId(id);
        car.setMake(fields[0]);
        car.setModel(fields[1]);
        car.setYear(Integer.parseInt(fields[2]));
        car.setWeight(Integer.parseInt(fields[3]));
        if ( !"-".equals(fields[4]) ) {
            final Engine engine= new Engine();
            engine.setId(id);
            engine.setKw(Double.parseDouble(fields[4]));
            car.setEngine(engine);
        }
        return car;
    };

    private final List<Car> myCars;

    /**
     * Default constructor for TestCarRepository.
     */
    public TestCarRepository() {
        this.myCars= new LinkedList<Car>();
        reset();
    }

    /**
     * Nullstill innholdet.
     */
    public void reset() {
        this.myCars.clear();
        for (final Car car : CARS) {
            this.myCars.add(car.clone());
        }
    }

    public int totalNoOfCars() {
        return this.myCars.size();
    }

    @Override
    public List<Car> findAll() {
        return new LinkedList<Car>(this.myCars);
    }

    @Override
    public List<Car> findNoImportTax() {
        final LinkedList<Car> result= new LinkedList<Car>();
        for (final Car car : this.myCars) {
            if ( !car.isImportTaxed() ) {
                result.add(car);
            }
        }
        return result;
    }

    @Override
    public void update(final Car newCar) {
        if ( this.myCars.contains(newCar) ) return; // auto-oppdatert...
        Car oldCar= null;
        for (final Car car : this.myCars) {
            if (car.getId() == newCar.getId() ) {
                oldCar= car;
                break;
            }
        }
        if ( oldCar==null ) {
            throw new RuntimeException("ukjent bil");
        }
        this.myCars.remove(oldCar);
        this.myCars.add(newCar);
    }
}
