package gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * Created by edotee on 16.03.17.
 */
public class Timer extends Label {
    private int time;
    private int currentTime;
    private boolean running;
    private Timeline timeline;

    public Timer(int _time, double _width) {
        time = _time;
        currentTime = time;
        this.setText("" + currentTime);
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(_width);
        if(Kenko.DEBUG) this.setStyle("-fx-background-color: red;");

        initTimer();

        this.setOnMouseClicked(mce -> toogleTimer());
    }

    public void setTimer(int _time) {
        time = _time;
    }

    public void startTimer() {
        running = true;
        timeline.play();

    }

    public void stopTimer() {
        running = false;
        timeline.stop();
    }

    public void resetTimer() {
        currentTime = time;
        displayTime();
    }

    private void initTimer() {
        running = false;

        timeline = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> {
                    currentTime -= 1;
                    displayTime();
                    if(currentTime <= 0)
                        stopTimer();
                })
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    private void toogleTimer() {
        if(running)
            stopTimer();
        else {
            if(currentTime <= 0)
                resetTimer();
            startTimer();
        }
    }

    private void displayTime() {
        this.setText("" + currentTime);
    }
}
