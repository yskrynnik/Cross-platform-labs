package main.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import main.models.Device;
import main.models.DeviceList;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseDeviceConfigController implements Initializable
{
    @FXML private JFXTextField deviceName;
    @FXML private CheckBox deviceSwitchedOn;

    private DeviceList deviceList;
    private Device device;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        deviceList = DeviceList.getInstance();
        device = deviceList.getSelectedDevice();

        Bindings.bindBidirectional(deviceSwitchedOn.selectedProperty(), device.enabledProperty());
        Bindings.bindBidirectional(deviceName.textProperty(), device.nameProperty());
    }
}
