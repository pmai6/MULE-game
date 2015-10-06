package mule.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import mule.RoundManager;

public class timer {

    @FXML
    private Timeline timeline;
    private IntegerProperty timeSeconds;
    private int startTime;
    public timer(int startTime) {
        this.startTime = startTime;
        this.timeSeconds = new SimpleIntegerProperty(startTime);
    }
    public void startTimer() {
        if (timeline != null) {
            timeline.stop();
        }
        timeSeconds.set(this.startTime);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(startTime + 1),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        timeline.setOnFinished(e-> RoundManager.playerFinishedTurn(false));
    }
    public IntegerProperty getTimeLeft() {
        return this.timeSeconds;
    }
    public IntegerProperty getTimeSeconds() {
        return this.timeSeconds;
    }
    public void stopTimer() {
        if (this.timeline != null) {
            timeline.stop();
        }
    }
    //for label
    //timerLabel.textProperty().bind(timeSeconds.asString());
    //timerLabel.setTextFill(Color.RED);
}
