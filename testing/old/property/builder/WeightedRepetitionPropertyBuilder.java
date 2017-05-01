package old.property.builder;

import exercise.ExerciseUnit;
import old.property.WeightedExerciseProperty;

/**
 * @author edotee
 */
public abstract class WeightedRepetitionPropertyBuilder implements PropertyBuilder<WeightedExerciseProperty> {

    public final static WeightedRepetitionPropertyBuilder builder = new WeightedRepetitionPropertyBuilder() {
        @Override
        public WeightedExerciseProperty build() {
            WeightedExerciseProperty result = new WeightedExerciseProperty();
            result.setValue(repetition);
            result.setUnit(repetitionUnit);
            result.setLoad(load);
            result.setLoadUnit(loadUnit);
            result.setStepping(stepping);
            return result;
        }
    };


    protected int repetition, stepping;
    protected double load;
    protected ExerciseUnit repetitionUnit, loadUnit;

    public WeightedRepetitionPropertyBuilder() { reset(); }

    public WeightedRepetitionPropertyBuilder repetition(int rep) {
        if(rep >= 0) this.repetition = rep;
        return this;
    }

    public WeightedRepetitionPropertyBuilder repetitionUnit(ExerciseUnit unit) {
        if(unit != null) this.repetitionUnit = unit;
        return this;
    }

    public WeightedRepetitionPropertyBuilder times() {
        this.repetitionUnit = ExerciseUnit.REP;
        return this;
    }

    public WeightedRepetitionPropertyBuilder minutes() {
        this.repetitionUnit = ExerciseUnit.MIN;
        return this;
    }

    public WeightedRepetitionPropertyBuilder load(double load) {
        if(load >= 0.0f) this.load = load;
        return this;
    }

    public WeightedRepetitionPropertyBuilder loadUnit(ExerciseUnit loadUnit) {
        if(loadUnit != null) this.loadUnit = loadUnit;
        return this;
    }

    public WeightedRepetitionPropertyBuilder kg() {
        this.loadUnit = ExerciseUnit.KG;
        return this;
    }

    public WeightedRepetitionPropertyBuilder lb() {
        this.loadUnit = ExerciseUnit.LB;
        return this;
    }

    public WeightedRepetitionPropertyBuilder res() {
        this.loadUnit = ExerciseUnit.RES;
        return this;
    }

    public WeightedRepetitionPropertyBuilder stepping(int stepping) {
        if(stepping >= 0) this.stepping = stepping;
        return this;
    }

    public WeightedRepetitionPropertyBuilder imprint(WeightedExerciseProperty property) {
        return repetition(property.getValue())
                .repetitionUnit(property.getUnit())
                .load(property.getLoad())
                .loadUnit(property.getLoadUnit())
                .stepping(property.getStepping());
    }

    public WeightedRepetitionPropertyBuilder reset() {
        return  repetition(0)
                .repetitionUnit(ExerciseUnit.REP)
                .load(0.0f)
                .loadUnit(ExerciseUnit.KG)
                .stepping(0);
    }
}
