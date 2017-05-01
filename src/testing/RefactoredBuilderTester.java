package testing;

import exercise.Exercise;
import exercise.ExerciseSet;
import exercise.ExerciseUnit;

/**
 * Created by edotee on 31.03.17.
 */
public class RefactoredBuilderTester {

    public static void main(String[] args) {
        //testCompoments();
        //testSets();
        testExercise();
    }

    public static void testCompoments() {
        ExerciseSet set1 = ExerciseSet.builder.repetition(4).times().build();
        ExerciseSet set2 = ExerciseSet.builder.repetition(8).times().load(35.0f).loadUnit(ExerciseUnit.KG).build();
        ExerciseSet set3 = ExerciseSet.builder.repetition(12).times().load(35.0f).loadUnit(ExerciseUnit.KG).build();
        Exercise<ExerciseSet> exercise = new Exercise("Brustpress Maschine", set1, set2, set3);
        System.out.println(set1.toString());
        System.out.println(set2.toString());
        System.out.println(set3.toString());
        System.out.println(exercise.toString());
    }

    public static void testExercise() {
        Exercise[] routine = new Exercise[100];
        routine[0] = new Exercise("Crosser",
                ExerciseSet.builder.repetition(5).minutes().build()
        );
        routine[1] = new Exercise("Brustpress Maschine",
                ExerciseSet.builder.repetition(12).times().load(45.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(45.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(45.0f).loadUnit(ExerciseUnit.KG).build()
        );
        routine[2] = new Exercise("Ruderzug Maschine",
                ExerciseSet.builder.repetition(12).times().load(45.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(45.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(45.0f).loadUnit(ExerciseUnit.KG).build()
        );
        routine[3] = new Exercise("Beinpress Maschine",
                ExerciseSet.builder.repetition(12).times().load(149.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(149.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(149.0f).loadUnit(ExerciseUnit.KG).build()
        );
        routine[4] = new Exercise("Klimmzug Maschine",
                ExerciseSet.builder.repetition(8).times().load(70.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(8).times().load(70.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(8).times().load(70.0f).loadUnit(ExerciseUnit.KG).build()
        );
        routine[5] = new Exercise("Schulterpress Maschine",
                ExerciseSet.builder.repetition(12).times().load(35.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(35.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(35.0f).loadUnit(ExerciseUnit.KG).build()
        );
        routine[6] = new Exercise("Butterfly Maschine",
                ExerciseSet.builder.repetition(12).times().load(35.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(35.0f).loadUnit(ExerciseUnit.KG).build(),
                ExerciseSet.builder.repetition(12).times().load(35.0f).loadUnit(ExerciseUnit.KG).build()
        );
        routine[6] = new Exercise("Crunches",
                ExerciseSet.builder.repetition(25).times().build(),
                ExerciseSet.builder.repetition(25).times().build(),
                ExerciseSet.builder.repetition(25).times().build()
        );
        routine[6] = new Exercise("Back Extensions",
                ExerciseSet.builder.repetition(12).times().build(),
                ExerciseSet.builder.repetition(12).times().build(),
                ExerciseSet.builder.repetition(12).times().build()
        );
        routine[6] = new Exercise("Oblique Crunches",
                ExerciseSet.builder.repetition(10).times().build(),
                ExerciseSet.builder.repetition(10).times().build(),
                ExerciseSet.builder.repetition(10).times().build()
        );

        for(Exercise r : routine)
            if(r != null)
                System.out.println(r.toString());
    }

    public static void testSets() {
        ExerciseSet[] rep = new ExerciseSet[100];
        rep[0] = ExerciseSet.builder.repetition(5).minutes().build();
        rep[1] = ExerciseSet.builder.repetition(10).times().build();
        rep[2] = ExerciseSet.builder.repetition(8).times().build();
        rep[3] = ExerciseSet.builder.repetition(6).times().build();
        rep[4] = ExerciseSet.builder.repetition(15).load(35).unit(ExerciseUnit.KG).stepping(5.0f).build();
        rep[5] = ExerciseSet.builder.imprint(rep[4]).repetition(12).build();
        rep[6] = ExerciseSet.builder.imprint(rep[4]).repetition(16).build();

        for(ExerciseSet r : rep)
            if(r != null)
                System.out.println(r.toString());
    }
}
