package main.controllers;

import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.MotionSensor;
import main.models.DeviceList;

import java.net.URL;
import java.util.ResourceBundle;

public class MotionSensorConfigController implements Initializable {
    @FXML private JFXSlider sensivity;

    private DeviceList deviceList;
    private MotionSensor motionSensor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        deviceList = DeviceList.getInstance();
        motionSensor = (MotionSensor) deviceList.getSelectedDevice();

        Bindings.bindBidirectional(sensivity.valueProperty(), motionSensor.sensivityProperty());
    }
}
