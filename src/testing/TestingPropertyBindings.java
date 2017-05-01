package testing;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by edotee on 05.04.17.
 */
public class TestingPropertyBindings extends Application {

    private Stage mainStage;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        mainStage.setTitle("The Binding of Properties");
        VBox layout = new VBox();

        SimpleStringProperty nameProperty = new SimpleStringProperty("Edotee");

        /*
        Label nameLabel = new Label();
        nameLabel.textProperty().bindBidirectional(nameProperty);

        TextField nameInput = new TextField();
        //nameInput.textProperty().bindBidirectional(nameLabel.textProperty());
        nameInput.textProperty().bindBidirectional(nameProperty);

        Button button = new Button("Hit me!");
        button.setOnAction(e -> {
            e.consume();
            System.out.println(nameProperty.toString());
        });
        layout.getChildren().addAll(nameLabel, nameInput, button);
        */

        /*
        Label labelA = new Label();
        TextField inputA = new TextField();
        inputA.textProperty().bind(labelA.textProperty());

        Label labelB = new Label();
        TextField inputB = new TextField();
        labelB.textProperty().bind(inputB.textProperty());
        layout.getChildren().addAll(labelA, inputA, labelB, inputB);
        */

        /*
        Label nameLabel = new Label();
        TextField inputA = new TextField();
        TextField inputB = new TextField();
        inputA.textProperty().bind(nameLabel.textProperty());
        inputB.textProperty().bindBidirectional(nameLabel.textProperty());
        layout.getChildren().addAll(nameLabel, inputA, inputB);
        */

        Label nameLabel = new Label();
        TextField inputA = new TextField();
        TextField inputB = new TextField();
        nameLabel.textProperty().bind(inputA.textProperty());
        nameLabel.textProperty().bind(inputB.textProperty());
        layout.getChildren().addAll(nameLabel, inputA, inputB);

        Scene scene = new Scene(layout);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
