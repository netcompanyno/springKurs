package no.mesan.car.domain;


/** A car... */
public class Car implements Cloneable {

    private long id;
    private String make;
    private String model;
    private int year;
    private int weight;
    private boolean importTaxed;
    private Engine engine;

    public int age(final int relativeTo) {
        return relativeTo-getYear();
    }

    @Override
    public String toString() {
        final StringBuilder builder= new StringBuilder();
        builder.append("Car [")
               .append(this.id)
               .append(", ").append(this.make)
               .append(", ").append(this.model)
               .append(", ").append(this.year)
               .append(", ").append(this.weight).append("kg")
               .append(" -- engine=").append(this.engine)
               .append("]");
        return builder.toString();
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        }
        catch (final CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id= id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(final String model) {
        this.model= model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(final int year) {
        this.year= year;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(final String make) {
        this.make= make;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(final int weight) {
        this.weight= weight;
    }

    public boolean isImportTaxed() {
        return this.importTaxed;
    }

    public void setImportTaxed(final boolean importTax) {
        this.importTaxed= importTax;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(final Engine engine) {
        this.engine= engine;
    }
}
