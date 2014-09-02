package no.mesan.spring.car.util;

/** Important for a functional car... */
public class Engine {
    private final String model;
    private double kw;
    private int cylinders;

    public Engine(final String model) {
        super();
        this.model= model;
    }

    public double getKw() {
        return this.kw;
    }

    public void setKw(final double kw) {
        this.kw= kw;
    }

    public int getCylinders() {
        return this.cylinders;
    }

    public void setCylinders(final int cylinders) {
        this.cylinders= cylinders;
    }

    @Override
    public String toString() {
        final StringBuilder builder= new StringBuilder();
        builder.append("Engine [model=").append(this.model)
               .append(", cyl=").append(this.cylinders)
               .append(", kw=").append(this.kw)
               .append("]");
        return builder.toString();
    }
}
