package gui;

import com.sun.javafx.collections.ObservableListWrapper;
import exercise.Exercise;
import exercise.ExerciseSet;
import exercise.ExerciseUnit;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edotee on 15.03.17.
 */
public class Kenko extends Application {

    public final static boolean DEBUG = false;

    private final String NAME = "gui.Kenko";
    private final double WIDTH = 480.0f;
    private final double HEIGHT = 854.0f;

    private Stage mainStage;
    private Timer timerDisplay;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        mainStage.setTitle(NAME);
        mainStage.setMinWidth(WIDTH);
        mainStage.setMinHeight(HEIGHT);

        timerDisplay = new Timer(5, WIDTH);
        ListView<ExerciseInput> routine = setupRoutineLayout(exercise());

        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(WIDTH, HEIGHT);

        mainLayout.setCenter(routine);
        mainLayout.setBottom(timerDisplay);

        Scene scene = new Scene(mainLayout);
        mainStage.setScene(scene);
        mainStage.sizeToScene();
        mainStage.show();
    }

    private ListView<ExerciseInput> setupRoutineLayout(List<Exercise> routine) {
        ArrayList<ExerciseInput> inputList = new ArrayList<>();
        for(Exercise e : routine)
            inputList.add(new ExerciseInput(e));

        ListView<ExerciseInput> routineNode = new ListView<>(new ObservableListWrapper(inputList));
        routineNode.setPrefSize(WIDTH, HEIGHT);
        routineNode.setOrientation(Orientation.VERTICAL);
        if(DEBUG) routineNode.setStyle("-fx-background-color: yellow;");

        return routineNode;
    }

    /*
    private ListView<Exercise> setupRoutineLayout(List<Exercise> routine) {
        VBox routineNode = new VBox();
        routineNode.setAlignment(Pos.CENTER);
        routineNode.setPrefSize(WIDTH, HEIGHT);
        if(DEBUG) routineNode.setStyle("-fx-background-color: yellow;");

        for(Exercise e : routine)
            routineNode.getChildren().add(new ExerciseInput(e));

        ScrollPane spane = new ScrollPane(routineNode);
        spane.setFitToHeight(true);
        spane.setFitToWidth(true);
        spane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        return spane; //routineNode;
    }
    */

   //Sample for testing purposes - TODO remove
    public final static List<Exercise> exercise() {
        List<Exercise> exercise = new ArrayList<>();
        exercise.add(new Exercise("Crosser",
                ExerciseSet.builder.repetition(6).minutes().load(120.0f).loadUnit(ExerciseUnit.KG).stepping(5.0f).build()
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
                ExerciseSet.builder.repetition(25).times().load(0.0f).loadUnit(ExerciseUnit.KG).stepping(0.0f).build(),
                ExerciseSet.builder.repetition(25).times().load(0.0f).loadUnit(ExerciseUnit.KG).stepping(0.0f).build(),
                ExerciseSet.builder.repetition(25).times().load(0.0f).loadUnit(ExerciseUnit.KG).stepping(0.0f).build()
        ));
        exercise.add(new Exercise("Back Extensions",
                ExerciseSet.builder.repetition(12).times().load(0.0f).loadUnit(ExerciseUnit.KG).stepping(0.0f).build(),
                ExerciseSet.builder.repetition(12).times().load(0.0f).loadUnit(ExerciseUnit.KG).stepping(0.0f).build(),
                ExerciseSet.builder.repetition(12).times().load(0.0f).loadUnit(ExerciseUnit.KG).stepping(0.0f).build()
        ));
        exercise.add(new Exercise("Oblique Crunches",
                ExerciseSet.builder.repetition(8).times().load(0.0f).loadUnit(ExerciseUnit.KG).stepping(8.0f).build(),
                ExerciseSet.builder.repetition(10).times().load(0.0f).loadUnit(ExerciseUnit.KG).stepping(8.0f).build(),
                ExerciseSet.builder.repetition(12).times().load(0.0f).loadUnit(ExerciseUnit.KG).stepping(8.0f).build()
        ));
        return exercise;
    }
}
