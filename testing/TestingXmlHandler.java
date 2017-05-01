import exercise.Exercise;
import exercise.ExerciseSet;
import exercise.ExerciseUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author edotee
 */
public class TestingXmlHandler {

    public static void main(String[] args) {
        List<Exercise> routine = exercise();
        XmlHandler xml = new XmlHandler();

        xml.writeRoutineDataToFile(routine);

        routine = xml.readRoutineData();

        for(Exercise e : routine)
            System.out.println(e.toString());
    }
    public final static List<Exercise> exercise() {
        List<Exercise> exercise = new ArrayList();
        exercise.add(new Exercise("Crosser",
                ExerciseSet.builder.repetition(6).minutes().load(120.0f).loadUnit(ExerciseUnit.RES).stepping(5.0f).build()
        ));
        exercise.add(new Exercise("Brustpresse Maschine",
                ExerciseSet.builder.repetition(8).times().load(45.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(10).times().load(45.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(12).times().load(45.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build()
        ));
        exercise.add(new Exercise("Ruderzug Maschine",
                ExerciseSet.builder.repetition(8).times().load(45.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(10).times().load(45.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(12).times().load(45.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build()
        ));
        exercise.add(new Exercise("Beinpresse Maschine",
                ExerciseSet.builder.repetition(8).times().load(157.0f).loadUnit(ExerciseUnit.KG).stepping(8.0f).build(),
                ExerciseSet.builder.repetition(10).times().load(157.0f).loadUnit(ExerciseUnit.KG).stepping(8.0f).build(),
                ExerciseSet.builder.repetition(12).times().load(157.0f).loadUnit(ExerciseUnit.KG).stepping(8.0f).build()
        ));
        exercise.add(new Exercise("Klimmzug Maschine",
                ExerciseSet.builder.repetition(8).times().load(60.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(10).times().load(60.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(12).times().load(60.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build()
        ));
        exercise.add(new Exercise("Schulterpresse Maschine",
                ExerciseSet.builder.repetition(8).times().load(45.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(10).times().load(45.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(12).times().load(45.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build()
        ));
        exercise.add(new Exercise("Butterfly Maschine",
                ExerciseSet.builder.repetition(8).times().load(40.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(10).times().load(40.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build(),
                ExerciseSet.builder.repetition(12).times().load(40.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build()
        ));
        exercise.add(new Exercise("Crunches",
                ExerciseSet.builder.repetition(25).times().load(0.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(25).times().load(0.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(25).times().load(0.0f).loadUnit(ExerciseUnit.KG).build()
        ));
        exercise.add(new Exercise("Back Extensions",
                ExerciseSet.builder.repetition(12).times().load(0.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(0.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(0.0f).loadUnit(ExerciseUnit.KG).build()
        ));
        exercise.add(new Exercise("Oblique Crunches",
                ExerciseSet.builder.repetition(8).times().build(),
                ExerciseSet.builder.repetition(10).times().build(),
                ExerciseSet.builder.repetition(12).times().build()
        ));
        return exercise;
    }
}
