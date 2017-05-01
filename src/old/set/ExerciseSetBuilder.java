package old.set;

import exercise.ExerciseUnit;

/**
 * Created by edotee on 30.03.17.
 */
public interface ExerciseSetBuilder {
    public ExerciseSetBuilder repetition(int rep);
    public ExerciseSetBuilder unit(ExerciseUnit unit);
    public ExerciseSetBuilder loadUnit(ExerciseUnit unit);
    public ExerciseSetBuilder times();
    public ExerciseSetBuilder minutes();
    public ExerciseSetBuilder imprint(ExerciseSet set);
    public ExerciseSetBuilder load(double load);
    public ExerciseSetBuilder stepping(double stepping);
    public ExerciseSetBuilder reset();
    public ExerciseSet build();
}