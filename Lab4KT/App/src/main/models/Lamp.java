package main.models;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

public class Lamp extends TimedDevice
{
    private final ObjectProperty<Color> color = new SimpleObjectProperty<Color>(Color.WHITE);
    private final IntegerProperty brightness = new SimpleIntegerProperty(100);

    public Color getColor()
    {
        return color.get();
    }
    public void setColor(Color color)
    {
        this.color.set(color);
    }

    public int getBrightness()
    {
        return brightness.get();
    }
    public void setBrightness(int brightness)
    {
        if(brightness > 100)
            brightness = 100;

        if(brightness < 10)
            brightness = 10;

        this.brightness.set(brightness);
    }
    public ObjectProperty<Color> colorProperty()
    {
        return color;
    }
    public IntegerProperty brightnessProperty()
    {
        return brightness;
    }

    public Lamp(String name)
    {
        super(name);
    }

}
