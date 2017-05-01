package exercise;

/**
 * Created by edotee on 16.03.17.
 */
public enum ExerciseUnit {
    REP("❌"), //Unicode number U+274C
    KG("㎏"), //Unicode number U+338F
    LB("lb"),
    MIN("min"),
    RES("resistance");

    private String displayText;

    private ExerciseUnit(String displayText) {
        this.displayText = displayText;
    }

    @Override
    public String toString() {
        return displayText;
    }
}
