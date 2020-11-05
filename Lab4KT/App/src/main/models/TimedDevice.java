package main.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.time.LocalTime;

public abstract class TimedDevice extends Device implements Timed
{
    private final ObjectProperty<LocalTime> startTime = new SimpleObjectProperty<LocalTime>(LocalTime.MIN);
    private final ObjectProperty<LocalTime> stopTime = new SimpleObjectProperty<LocalTime>(LocalTime.MAX);
    private final BooleanProperty startTimer = new SimpleBooleanProperty(false);
    private final BooleanProperty stopTimer = new SimpleBooleanProperty(false);



    @Override
    public LocalTime getStartTime()
    {
        return startTime.get();
    }
    @Override
    public void setStartTime(LocalTime time)
    {
        this.startTime.set(time);
    }

    @Override
    public LocalTime getStopTime()
    {
        return stopTime.get();
    }
    @Override
    public void setStopTime(LocalTime time)
    {
        this.stopTime.set(time);
    }

    @Override
    public boolean isStartTimerSet()
    {
        return startTimer.get();
    }
    @Override
    public void setStartTimer(boolean timer)
    {
        this.startTimer.set(timer);
    }

    @Override
    public boolean isStopTimerSet()
    {
        return stopTimer.get();
    }
    @Override
    public void setStopTimer(boolean timer)
    {
        this.stopTimer.set(timer);
    }


    @Override
    public ObjectProperty<LocalTime> startTimeProperty()
    {
        return startTime;
    }
    @Override
    public ObjectProperty<LocalTime> stopTimeProperty()
    {
        return stopTime;
    }
    @Override
    public BooleanProperty startTimerProperty()
    {
        return startTimer;
    }
    @Override
    public BooleanProperty stopTimerProperty()
    {
        return stopTimer;
    }

    public TimedDevice(String name)
    {
        super(name);
    }
}