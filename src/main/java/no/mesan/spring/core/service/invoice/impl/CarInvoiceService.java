package no.mesan.spring.core.service.invoice.impl;

import java.util.LinkedList;
import java.util.List;

import no.mesan.spring.core.domain.car.Car;
import no.mesan.spring.core.domain.car.CarRepository;
import no.mesan.spring.core.service.domain.car.DbCarRepository;
import no.mesan.spring.core.service.invoice.InvoiceService;
import no.mesan.spring.core.service.tax.Tax;
import no.mesan.spring.core.service.tax.impl.AnnualTaxService;
import no.mesan.spring.core.service.tax.impl.ImportTaxService;


/**
 * Implementasjon av {@link InvoiceService}.
 */
public class CarInvoiceService implements InvoiceService {

    private final AnnualTaxService annualTaxService;
    private final ImportTaxService importTaxService;
    private CarRepository repository;


    /**
     * Default constructor for CarInvoiceService.
     */
    public CarInvoiceService() {
        this.annualTaxService= new AnnualTaxService();
        this.importTaxService= new ImportTaxService();
        this.repository= new DbCarRepository();
    }

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
