package gui;

import exercise.ExerciseSet;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;

/**
 * Created by edotee on 05.04.17.
 */
public class SetInput extends GridPane {

    private ExerciseSet eset;
    private Label repUnitLabel;
    private Label loadUnitLabel;
    private Spinner<Integer> repDisplay;
    private Spinner<Double> loadDisplay;

    public SetInput(ExerciseSet set) {
        eset = set;

        SpinnerValueFactory repSVF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, eset.getRepetition(), 1);
        repSVF.valueProperty().bindBidirectional(eset.repetitionProperty());
        repDisplay = new Spinner(repSVF);
        repUnitLabel = new Label(eset.getRepetitionUnit().toString());
        //repUnitLabel.textProperty().bindBidirectional(eset.unitProperty());
        repUnitLabel.setAlignment(Pos.CENTER);

        SpinnerValueFactory loadSVF = new SpinnerValueFactory.DoubleSpinnerValueFactory(5.0f, 325.0f, eset.getLoad(), eset.getStepping());
        loadSVF.valueProperty().bindBidirectional(eset.loadProperty());
        loadDisplay = new Spinner(loadSVF);
        loadUnitLabel = new Label(eset.getLoadUnit().toString());
        //loadUnitLabel.textProperty().bindBidirectional(eset.loadUnitProperty());
        loadUnitLabel.setAlignment(Pos.CENTER);

        GridPane.setConstraints(repDisplay,0,0);
        GridPane.setConstraints(repUnitLabel,1,0);
        GridPane.setConstraints(loadDisplay,3,0);
        GridPane.setConstraints(loadUnitLabel,4,0);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10.0F,10.0F,10.0F,10.0F));
        this.setVgap(8.0f);
        this.setHgap(2.0f);
        this.getChildren().addAll(repUnitLabel, loadUnitLabel, repDisplay, loadDisplay);
        if(Kenko.DEBUG) this.setStyle("-fx-background-color: slateblue;");
    }

    /*
    public SetInput(ExerciseSet set) {
        eset = set;

        repDisplay = new Spinner(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, eset.getValue(), 1));
        repUnitLabel = new Label(eset.getUnit().toString());
        repUnitLabel.setAlignment(Pos.CENTER);

        loadDisplay = new Spinner(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0f, 350.0f, eset.getLoad(), eset.getStepping()));
        loadUnitLabel = new Label(eset.getLoadUnit().toString());
        loadUnitLabel.setAlignment(Pos.CENTER);

        GridPane.setConstraints(repDisplay,0,0);
        GridPane.setConstraints(repUnitLabel,1,0);
        GridPane.setConstraints(loadDisplay,3,0);
        GridPane.setConstraints(loadUnitLabel,4,0);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10.0F,10.0F,10.0F,10.0F));
        this.setVgap(8.0f);
        this.setHgap(2.0f);
        this.getChildren().addAll(repUnitLabel, loadUnitLabel, repDisplay, loadDisplay);
        this.setStyle("-fx-background-color: slateblue;"); //debug
    }
     */
}