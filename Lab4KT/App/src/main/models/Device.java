package main.models;

import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.util.Callback;


public abstract class Device
{
    private final StringProperty name = new SimpleStringProperty();
    private final BooleanProperty enabled = new SimpleBooleanProperty(false);

    public String getName()
    {
        return name.get();
    }
    public void setName(String name)
    {
        this.name.set(name);
    }

    public boolean isEnabled()
    {
        return enabled.get();
    }
    public void setEnabled(boolean enabled)
    {
        this.enabled.set(enabled);
    }

    public StringProperty nameProperty()
    {
        return name;
    }
    public BooleanProperty enabledProperty()
    {
        return enabled;
    }

    public Device(String name)
    {
        setName(name);
    }

    public static Callback<Device, Observable[]> extractor() {
        return new Callback<Device, Observable[]>() {
            @Override
            public Observable[] call(Device param) {
                return new Observable[]{param.enabled, param.name};
            }
        };
    }
}