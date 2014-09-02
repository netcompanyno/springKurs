package no.mesan.spring.hellocar;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;

/** A car... */
public class Car {

    @NotNull
    @Size(min=1, max=128)
    private String make;

    @NotNull
    @Size(min=1, max=128)
    private String model;

    @Min(1900) @Max(2050)
    private int year;

    @Min(0) @Max(10)
    private int doors;

    private boolean fourWd;

    @Resource
    @NotNull
    private Engine engine;

    private List<String> extras;

    public Car() {
        System.out.println("Car created");
    }

    public String getModel() {
        return this.model;
    }

    @Required
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

    public int getYear() {
        return this.year;
    }

    @Required
    public void setYear(final int year) {
        this.year= year;
    }

    public List<String> getExtras() {
        return this.extras;
    }

    public void setExtras(final List<String> extras) {
        this.extras= extras;
    }


    public String getMake() {
        return this.make;
    }

    @Required
    public void setMake(final String make) {
        this.make= make;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(final Engine engine) {
        this.engine= engine;
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
