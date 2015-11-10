package mule.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.util.Duration;
import mule.RoundManager;

public class Timer {

    @FXML
    private Timeline timeline;
    private IntegerProperty timeSeconds;
    private int startTime;
    public Timer(int startTime) {
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
    public int getIntTimeLeft() {
        return timeSeconds.get();
    }

    public IntegerProperty getTimeSeconds() {
        return this.timeSeconds;
    }
    public void stopTimer() {
        if (this.timeline != null) {
            timeline.stop();
        }
    }
}
