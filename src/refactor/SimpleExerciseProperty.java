package refactor;

import exercise.ExerciseUnit;
import javafx.beans.property.SimpleDoubleProperty;

import java.io.Serializable;

/**
 * Created by edotee on 05.04.17.
 */
public class SimpleExerciseProperty implements Serializable{

    private SimpleDoubleProperty value;
    private ExerciseUnit unit;

    public SimpleExerciseProperty() {
        this.value = new SimpleDoubleProperty(0.0f);
        this.unit = ExerciseUnit.REP;
    }

    public double getValue() { return value.get(); }
    public SimpleDoubleProperty valueProperty() { return value; }
    public void setValue(double value) { this.value.set(value); }

    public ExerciseUnit getUnit() { return unit; }
    public void setUnit(ExerciseUnit unit) { this.unit = unit; }
}