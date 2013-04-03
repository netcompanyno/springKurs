package no.mesan.spring.core.domain.car;


/** Important for a functional car... */
public class Engine {

    private long id;
    private double kw;

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id= id;
    }

    public double getKw() {
        return this.kw;
    }

    public void setKw(final double kw) {
        this.kw= kw;
    }

    @Override
    public String toString() {
        final StringBuilder builder= new StringBuilder();
        builder.append("Engine [")
               .append(this.id)
               .append(", ").append(this.kw).append("kw")
               .append("]");
        return builder.toString();
    }

}
