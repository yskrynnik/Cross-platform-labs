package main.models;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeviceList {
    private static DeviceList instance;
    private final ListProperty<Device> items = new SimpleListProperty<Device>(FXCollections.observableArrayList(Device.extractor()));
    private final ObjectProperty<Device> selectedDevice = new SimpleObjectProperty<Device>();

    public ObservableList<Device> getItems()
    {
        return items.get();
    }
    public Device getSelectedDevice()
    {
        return selectedDevice.get();
    }
    public void setSelectedDevice(Device selectedDevice)
    {
        this.selectedDevice.set(selectedDevice);
    }

    public ListProperty<Device> itemsProperty()
    {
        return items;
    }
    public ObjectProperty<Device> selectedDeviceProperty()
    {
        return selectedDevice;
    }

    private DeviceList()
    {

    }

    public static DeviceList getInstance()
    {
        if (instance == null)
        {
            instance = new DeviceList();
        }
        return instance;
    }
}
