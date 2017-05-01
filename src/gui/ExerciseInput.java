package gui;

import exercise.Exercise;
import exercise.ExerciseSet;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by edotee on 16.03.17.
 */
public class ExerciseInput extends VBox {

    private Exercise<ExerciseSet> exercise;
    private Label nameLabel;

    public ExerciseInput(Exercise<ExerciseSet> exercise) {
        this.exercise = exercise;
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10.0F,10.0F,10.0F,10.0F));
        if(Kenko.DEBUG) this.setStyle("-fx-background-color: slateblue;");

        nameLabel = new Label();
        nameLabel.textProperty().bindBidirectional(exercise.nameProperty());
        this.getChildren().add(nameLabel);

        for(ExerciseSet es : this.exercise.getSets())
            this.getChildren().add(new SetInput(es));
    }
}
