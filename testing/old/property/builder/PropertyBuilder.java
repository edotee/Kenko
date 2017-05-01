package old.property.builder;

import old.property.SimpleExerciseProperty;

/**
 * @author edotee
 */
public interface PropertyBuilder<T extends SimpleExerciseProperty> {
    PropertyBuilder imprint(T property);
    PropertyBuilder reset();
    T build();
}
