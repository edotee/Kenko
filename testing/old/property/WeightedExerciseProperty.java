package old.property;

import exercise.ExerciseUnit;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author edotee
 */
public class WeightedExerciseProperty extends SimpleExerciseProperty {

    private final SimpleDoubleProperty load;
    private ExerciseUnit loadUnit;
    private final SimpleIntegerProperty stepping;

    public WeightedExerciseProperty() {
        super();
        setValue(0);
        setUnit(ExerciseUnit.REP);
        this.load = new SimpleDoubleProperty(0.0f);
        this.loadUnit = ExerciseUnit.RES;
        this.stepping = new SimpleIntegerProperty(0);
    }

    public double getLoad() { return load.get(); }
    public SimpleDoubleProperty loadProperty() { return load; }
    public void setLoad(double load) { this.load.set(load); }

    public ExerciseUnit getLoadUnit() { return loadUnit; }
    public void setLoadUnit(ExerciseUnit loadUnit) { this.loadUnit = loadUnit; }

    public int getStepping() { return stepping.get(); }
    public SimpleIntegerProperty steppingProperty() { return stepping; }
    public void setStepping(int stepping) { this.stepping.set(stepping); }
}