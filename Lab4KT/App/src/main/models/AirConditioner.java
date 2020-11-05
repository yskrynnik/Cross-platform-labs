package main.models;

import javafx.beans.property.*;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;

public class AirConditioner extends TimedDevice {

    private final IntegerProperty temperature = new SimpleIntegerProperty(100);
    private final IntegerProperty fanSpeed = new SimpleIntegerProperty(2);
    private final IntegerProperty swingAngle = new SimpleIntegerProperty(45);
    private final StringProperty mode = new SimpleStringProperty();
    private final BooleanProperty sleepModeOn = new SimpleBooleanProperty();

    public int getTemperature()
    {
        return temperature.get();
    }
    public void setTemperature(int temperature)
    {
        if(temperature > 43)
            temperature = 43;

        if(temperature < -5)
            temperature = -5;

        this.temperature.set(temperature);
    }

    public int getFanSpeed()
    {
        return fanSpeed.get();
    }
    public void setFanSpeed(int fanSpeed)
    {
        if(fanSpeed > 5)
            fanSpeed = 5;

        if(fanSpeed < 1)
            fanSpeed = 1;

        this.fanSpeed.set(fanSpeed);
    }

    public int getSwingAngle()
    {
        return swingAngle.get();
    }
    public void setSwingAngle(int swingAngle)
    {
        if(swingAngle > 90)
            swingAngle = 90;

        if(swingAngle < 0)
            swingAngle = 0;

        this.fanSpeed.set(swingAngle);
    }

    public boolean isSleepModeOn() { return sleepModeOn.get(); }
    public void setSleepModeOn(boolean sleepModeOn) { this.sleepModeOn.set(sleepModeOn); }
    public String getMode() { return mode.get(); }
    public void setMode(String Mode) { this.mode.set(Mode); }

    public IntegerProperty temperatureProperty()
    {
        return temperature;
    }
    public IntegerProperty fanSpeedProperty()
    {
        return fanSpeed;
    }
    public IntegerProperty swingAngleProperty() { return swingAngle; }
    public BooleanProperty sleepModeEnabledProperty() { return sleepModeOn; }
    public StringProperty modeProperty() { return mode; }

    public AirConditioner(String name)
    {
        super(name);
    }
}
