package main.controllers;

import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.DeviceList;
import main.models.Thermometer;

import java.net.URL;
import java.util.ResourceBundle;

public class ThermometerConfigController implements Initializable {
    @FXML
    private JFXSlider pollPeriod;

    private DeviceList deviceList;
    private Thermometer thermometer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        deviceList = DeviceList.getInstance();
        thermometer = (Thermometer)deviceList.getSelectedDevice();

        Bindings.bindBidirectional(pollPeriod.valueProperty(), thermometer.PollPeriodProperty());
    }
}
