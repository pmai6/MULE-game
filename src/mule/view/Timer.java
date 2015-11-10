package mule.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.util.Duration;
import mule.RoundManager;

/**
 * The type Timer.
 */
public class Timer {

    /**
     * The Timeline.
     */
    @FXML
    private Timeline timeline;
    /**
     * The Time seconds.
     */
    private IntegerProperty timeSeconds;
    /**
     * The Start time.
     */
    private int startTime;

    /**
     * Instantiates a new Timer.
     *
     * @param startTime the start time
     */
    public Timer(int startTime) {
        this.startTime = startTime;
        this.timeSeconds = new SimpleIntegerProperty(startTime);
    }

    /**
     * Start timer.
     */
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

    /**
     * Gets time left.
     *
     * @return the time left
     */
    public IntegerProperty getTimeLeft() {
        return this.timeSeconds;
    }

    /**
     * Gets int time left.
     *
     * @return the int time left
     */
    public int getIntTimeLeft() {
        return timeSeconds.get();
    }

    /**
     * Gets time seconds.
     *
     * @return the time seconds
     */
    public IntegerProperty getTimeSeconds() {
        return this.timeSeconds;
    }

    /**
     * Stop timer.
     */
    public void stopTimer() {
        if (this.timeline != null) {
            timeline.stop();
        }
    }
}
