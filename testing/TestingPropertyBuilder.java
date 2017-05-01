import old.property.builder.WeightedRepetitionPropertyBuilder;
import old.property.WeightedExerciseProperty;

/**
 * @author edotee
 */
public class TestingPropertyBuilder {
    public static void main(String[] args) {
        WeightedExerciseProperty prop = WeightedRepetitionPropertyBuilder.builder.repetition(12).load(157).build();
        System.out.println("" + prop.getValue() + " " + prop.getUnit() + " " + prop.getLoad() + prop.getLoadUnit());
    }
}
