package no.mesan.spring.hellocar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/** Important for a functional car... */
@Component("defaultEngine")
@Scope("prototype")
public class Engine {
    private String model;
    private double kw;
    private int cylinders;

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

    public String getModel() {
        return this.model;
    }

    @Autowired @Required
    public void setModel(@Value("default") final String model) {
        this.model= model;
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
