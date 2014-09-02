package no.mesan.spring.car.xml;

import java.util.List;

/** A car... */
public class Car {

    private final String make;
    private String model;
    private int year;
    private int doors;
    private boolean fourWd;
    private Engine engine;
    private List<String> extras;

    public Car(final String make, final int year) {
        this.make= make;
        this.year= year;
    }

    public String getModel() {
        return this.model;
    }

    public String getMake() {
        return this.make;
    }

    public void setModel(final String model) {
        this.model= model;
    }

    public int getDoors() {
        return this.doors;
    }

    public void setDoors(final int doors) {
        this.doors= doors;
    }

    public boolean isFourWd() {
        return this.fourWd;
    }

    public void setFourWd(final boolean fourWd) {
        this.fourWd= fourWd;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(final Engine engine) {
        this.engine= engine;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(final int year) {
        this.year= year;
    }

    public List<String> getExtras() {
        return this.extras;
    }

    public void setExtras(final List<String> extras) {
        this.extras= extras;
    }

    @Override
    public String toString() {
        final StringBuilder builder= new StringBuilder();
        final String extra= (this.extras==null)? "-" : this.extras.toString();
        builder.append("Car [").append(this.make)
               .append(" ").append(this.model)
               .append(", ").append(this.year)
               .append(", 4WD=").append(this.fourWd)
               .append(", extras: ").append(extra)
               .append(" -- engine=").append(this.engine)
               .append("]");
        return builder.toString();
    }
}
