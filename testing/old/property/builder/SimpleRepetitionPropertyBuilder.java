package old.property.builder;

import exercise.ExerciseUnit;
import old.property.SimpleExerciseProperty;

/**
 * @author edotee
 */
public abstract class SimpleRepetitionPropertyBuilder implements PropertyBuilder<SimpleExerciseProperty> {

    public final static SimpleRepetitionPropertyBuilder builder = new SimpleRepetitionPropertyBuilder() {
        @Override
        public SimpleExerciseProperty build() {
            SimpleExerciseProperty result = new SimpleExerciseProperty();
            result.setValue(repetition);
            result.setUnit(repetitionUnit);
            return result;
        }
    };

    protected int repetition;
    protected ExerciseUnit repetitionUnit;

    public SimpleRepetitionPropertyBuilder() { reset(); }

    public SimpleRepetitionPropertyBuilder repetition(int rep) {
        if(rep >= 0) this.repetition = rep;
        return this;
    }

    public SimpleRepetitionPropertyBuilder repetitionUnit(ExerciseUnit unit) {
        if(unit != null) this.repetitionUnit = unit;
        return this;
    }

    public SimpleRepetitionPropertyBuilder times() {
        this.repetitionUnit = ExerciseUnit.REP;
        return this;
    }

    public SimpleRepetitionPropertyBuilder minutes() {
        this.repetitionUnit = ExerciseUnit.MIN;
        return this;
    }

    public SimpleRepetitionPropertyBuilder imprint(SimpleExerciseProperty property) {
        return repetition(property.getValue()).repetitionUnit(property.getUnit());
    }

    public SimpleRepetitionPropertyBuilder reset() {
        return repetition(0).repetitionUnit(ExerciseUnit.REP);
    }
}
