package main.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import main.models.Device;
import main.models.DeviceList;
import main.models.Timed;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ConfigDeviceController implements Initializable
{
    @FXML private VBox vbox;

    private DeviceList deviceList;
    private Device device;

    public void switchDevice(ActionEvent actionEvent)
    {
        device.setEnabled(!device.isEnabled());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        List<String> views = new ArrayList<String>();

        deviceList  = DeviceList.getInstance();
        device = deviceList.getSelectedDevice();

        vbox.getChildren().clear();
        views.add("/main/views/baseDeviceConfigView.fxml");

        if(device instanceof Timed)
        {
            views.add("/main/views/timedDeviceConfigView.fxml");
        }

        switch (device.getClass().getSimpleName())
        {
            case "AirConditioner":
                views.add("/main/views/airConditionerConfigView.fxml"); break;
            case "Fridge":
                views.add("/main/views/fridgeConfigView.fxml"); break;
            case "Lamp":
                views.add("/main/views/lampConfigView.fxml"); break;
            case "MotionSensor":
                views.add("/main/views/motionSensorConfigView.fxml"); break;
            case "Thermometer":
                views.add("/main/views/thermometerConfigView.fxml"); break;
        }

        try
        {
            for (String view : views)
            {
                vbox.getChildren().add(FXMLLoader.load(getClass().getResource(view)));
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
