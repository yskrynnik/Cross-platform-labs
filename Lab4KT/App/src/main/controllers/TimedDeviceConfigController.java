package main.controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTimePicker;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.DeviceList;
import main.models.Timed;

import java.net.URL;
import java.util.ResourceBundle;

public class TimedDeviceConfigController implements Initializable
{
    @FXML private JFXTimePicker startTime;
    @FXML private JFXTimePicker stopTime;
    @FXML private JFXCheckBox startTimer;
    @FXML private JFXCheckBox stopTimer;

    private DeviceList deviceList;
    private Timed device;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        deviceList = DeviceList.getInstance();
        device = (Timed)deviceList.getSelectedDevice();

        startTime.set24HourView(true);
        stopTime.set24HourView(true);

        Bindings.bindBidirectional(startTimer.selectedProperty(), device.startTimerProperty());
        Bindings.bindBidirectional(stopTimer.selectedProperty(), device.stopTimerProperty());
        Bindings.bindBidirectional(startTime.valueProperty(), device.startTimeProperty());
        Bindings.bindBidirectional(stopTime.valueProperty(), device.stopTimeProperty());
    }
}
