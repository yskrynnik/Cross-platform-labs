package main.controllers;

import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.Lamp;
import main.models.DeviceList;

import java.net.URL;
import java.util.ResourceBundle;

public class LampConfigController implements Initializable
{
    @FXML private JFXColorPicker lampColor;
    @FXML private JFXSlider brightness;

    private DeviceList deviceList;
    private Lamp lamp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        deviceList = DeviceList.getInstance();
        lamp = (Lamp)deviceList.getSelectedDevice();

        Bindings.bindBidirectional(lampColor.valueProperty(), lamp.colorProperty());
        Bindings.bindBidirectional(brightness.valueProperty(), lamp.brightnessProperty());
    }
}
