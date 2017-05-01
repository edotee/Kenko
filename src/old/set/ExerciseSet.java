package old.set;

import exercise.ExerciseUnit;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by edotee on 16.03.17.
 * A simple JavaBean that holds all relevant information for 1 set of an old
 * It also has a nested implementation of its own builder.
 */
@XmlType( propOrder = { "repetition", "repetitionUnit", "load", "loadUnit" , "stepping"} )
public class ExerciseSet implements Serializable {

    public final static ExerciseSetBuilder builder = new ExerciseSetBuilderImpl();

    //TODO Implement repetitionUnit & loadUnit as property
    private final SimpleIntegerProperty repetition;
    private ExerciseUnit repetitionUnit, loadUnit;
    private final SimpleDoubleProperty load, stepping;

    public ExerciseSet() {
        repetition = new SimpleIntegerProperty(1);
        setRepetitionUnit(ExerciseUnit.REP);
        setRepetitionUnit(ExerciseUnit.KG);
        load = new SimpleDoubleProperty(0.0f);
        stepping = new SimpleDoubleProperty(1.0f);
    }

    @Override
    public String toString() {
        String result = "";
        if(repetition != null)  result += repetition.get() + " ";
        if(repetitionUnit != null)  result += repetitionUnit.toString() + " ";
        if(load != null)  result += ((load.get() % 1 == 0)? (int) load.get() : load.get()) + " ";
        if(loadUnit != null)  result += loadUnit.toString() + " ";
        return result;
    }

    //@XmlElement(name = "REPETITION")
    public int getRepetition() { return this.repetition.get(); }
    public void setRepetition(int rep) { this.repetition.set(rep); }
    public SimpleIntegerProperty repetitionProperty() { return this.repetition;}

    @XmlElement(name = "repUnit")
    public ExerciseUnit getRepetitionUnit() { return this.repetitionUnit; }
    public void setRepetitionUnit(ExerciseUnit repetitionUnit) { this.repetitionUnit = repetitionUnit; }

    //@XmlElement(name = "LOAD")
    public double getLoad() { return this.load.get(); }
    public void setLoad(double load) { this.load.set(load); }
    public SimpleDoubleProperty loadProperty() { return this.load; }

    //@XmlElement(name = "STEPPING")
    public double getStepping() { return this.stepping.get(); }
    public void setStepping(double stepping) { this.stepping.set(stepping); }
    public SimpleDoubleProperty steppingProperty() { return this.stepping; };

    //@XmlElement(name = "LOADUNIT")
    public ExerciseUnit getLoadUnit() { return this.loadUnit; }
    public void setLoadUnit(ExerciseUnit unit) { this.loadUnit = unit; }

    private static class ExerciseSetBuilderImpl implements ExerciseSetBuilder {

        int repetition; double load, stepping; ExerciseUnit unit, loadUnit;

        @Override
        public ExerciseSetBuilder repetition(int rep) {
            if(rep > 0) this.repetition = rep;
            return this;
        }

        @Override
        public ExerciseSetBuilder unit(ExerciseUnit unit) {
            if(unit != null) this.unit = unit;
            return this;
        }

        @Override
        public ExerciseSetBuilder loadUnit(ExerciseUnit unit) {
            if(unit != null) this.loadUnit = unit;
            return this;
        }

        @Override
        public ExerciseSetBuilder times() {
            return unit(ExerciseUnit.REP);
        }

        @Override
        public ExerciseSetBuilder minutes() {
            return unit(ExerciseUnit.MIN);
        }

        @Override
        public ExerciseSetBuilder load(double load) {
            if(load > 0.0f) this.load = load;
            return this;
        }

        @Override
        public ExerciseSetBuilder stepping(double stepping) {
            if(stepping > 0.0) this.stepping = stepping;
            return this;
        }

        @Override
        public ExerciseSetBuilder imprint(ExerciseSet set) {
            this.repetition = set.getRepetition();
            this.unit = set.getRepetitionUnit();
            this.loadUnit = set.getLoadUnit();
            this.load = set.getLoad();
            this.stepping = set.getStepping();
            return this;
        }

        @Override
        public ExerciseSetBuilder reset() {
            this.repetition = 1;
            this.unit = ExerciseUnit.REP;
            this.loadUnit = ExerciseUnit.KG;
            this.load = 0.0f;
            this.stepping = 1.0f;
            return this;
        }

        @Override
        public ExerciseSet build() {
            ExerciseSet result = new ExerciseSet();
            result.setRepetition(repetition);
            result.setRepetitionUnit(unit);
            result.setLoadUnit(loadUnit);
            result.setLoad(load);
            result.setStepping(stepping);
            reset();
            return result;
        }
    }
}