package old.set;

import exercise.ExerciseUnit;

/**
 * @author edotee
 */
public interface ExerciseSetBuilder {
    ExerciseSetBuilder repetition(int rep);
    ExerciseSetBuilder unit(ExerciseUnit unit);
    ExerciseSetBuilder loadUnit(ExerciseUnit unit);
    ExerciseSetBuilder times();
    ExerciseSetBuilder minutes();
    ExerciseSetBuilder imprint(ExerciseSet set);
    ExerciseSetBuilder load(double load);
    ExerciseSetBuilder stepping(double stepping);
    ExerciseSetBuilder reset();
    ExerciseSet build();
}