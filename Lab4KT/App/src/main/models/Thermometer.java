package main.models;
import javafx.beans.property.*;

public class Thermometer extends Device{
    private final IntegerProperty pollPeriodMs = new SimpleIntegerProperty(500);

    public int getPollPeriod()
    {
        return pollPeriodMs.get();
    }
    public void setTemperature(int pollPeriodMs)
    {
        if(pollPeriodMs > 10000)
            pollPeriodMs = 10000;

        if(pollPeriodMs < 1)
            pollPeriodMs = 1;

        this.pollPeriodMs.set(pollPeriodMs);
    }

    public IntegerProperty PollPeriodProperty()
    {
        return pollPeriodMs;
    }

    public Thermometer(String name) { super(name); }
}
