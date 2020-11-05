package main.models;
import javafx.beans.property.*;

public class MotionSensor extends Device {
    private final IntegerProperty sensivity = new SimpleIntegerProperty(50);

    public int getSensivity()
    {
        return sensivity.get();
    }
    public void setSensivity(int sensivity)
    {
        if(sensivity > 100)
            sensivity = 100;

        if(sensivity < 1)
            sensivity = 1;

        this.sensivity.set(sensivity);
    }

    public IntegerProperty sensivityProperty()
    {
        return sensivity;
    }

    public MotionSensor(String name) { super(name); }
}
