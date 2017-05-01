package exercise.builder;

import exercise.SimpleExerciseProperty;

/**
 * Created by edotee on 05.04.17.
 */
public interface PropertyBuilder<T extends SimpleExerciseProperty> {
    public PropertyBuilder imprint(T property);
    public PropertyBuilder reset();
    public T build();
}
