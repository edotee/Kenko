package old.property;

import exercise.ExerciseUnit;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author edotee
 */
public class SimpleExerciseProperty {


    private SimpleIntegerProperty value;
    private ExerciseUnit unit;

    public SimpleExerciseProperty() {
        this.value = new SimpleIntegerProperty(0);
        this.unit = ExerciseUnit.REP;
    }

    public int getValue() { return value.get(); }
    public SimpleIntegerProperty valueProperty() { return value; }
    public void setValue(int value) { this.value.set(value); }

    public ExerciseUnit getUnit() { return unit; }
    public void setUnit(ExerciseUnit unit) { this.unit = unit; }
}
