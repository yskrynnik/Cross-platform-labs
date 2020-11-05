package main.models;
import javafx.beans.property.*;

public class Fridge extends Device {
    private final IntegerProperty temperature = new SimpleIntegerProperty(6);

    public int getTemperature()
    {
        return temperature.get();
    }
    public void setTemperature(int temperature)
    {
        if(temperature > 10)
            temperature = 10;

        if(temperature < 2)
            temperature = 2;

        this.temperature.set(temperature);
    }

    public IntegerProperty temperatureProperty()
    {
        return temperature;
    }

    public Fridge(String name) { super(name); }
}
