package no.mesan.spring.core.service.invoice.impl;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import no.mesan.spring.core.domain.car.Car;
import no.mesan.spring.core.domain.car.CarRepository;
import no.mesan.spring.core.service.invoice.InvoiceService;
import no.mesan.spring.core.service.tax.Tax;
import no.mesan.spring.core.service.tax.impl.AnnualTaxService;
import no.mesan.spring.core.service.tax.impl.ImportTaxService;


/**
 * Implementasjon av {@link InvoiceService}.
 */
@Service
public class CarInvoiceService implements InvoiceService {

    @Inject
    private AnnualTaxService annualTaxService;

    @Inject
    private ImportTaxService importTaxService;

    @Inject @Named("stdCarRepository")
    private CarRepository repository;

    public void setRepository(final CarRepository repository) {
        this.repository= repository;
    }

    protected List<Tax> annualTax(final List<Car> cars) {
        final List<Tax> list= new LinkedList<Tax>();
        for (final Car car : cars) {
            final Tax tax= this.annualTaxService.calculateTax(car);
            if ( tax.sum > 0.0D ) {
                list.add(tax);
            }
        }
        return list;
    }

    @Override
    public List<Tax> annualTax() {
        return annualTax(this.repository.findAll());
    }

    @Override
    public List<Tax> importTax(final List<Car> cars) {
        final List<Tax> list= new LinkedList<Tax>();
        for (final Car car : cars) {
            final Tax tax= this.importTaxService.calculateTax(car);
            list.add(tax);
        }
        return list;
    }

    @Override
    public List<Tax> importTax() {
        final List<Car> carList= this.repository.findNoImportTax();
        final List<Tax> importTax= importTax(carList);
        for (final Car car : carList) {
            car.setImportTaxed(true);
            this.repository.update(car);
        }
        return importTax;
    }
}
