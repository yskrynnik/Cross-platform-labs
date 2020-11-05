package main.controllers;
;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.models.Fridge;
import main.models.DeviceList;

import java.net.URL;
import java.util.ResourceBundle;

public class FridgeConfigController implements Initializable {
    @FXML private JFXSlider temperature;

    private DeviceList deviceList;
    private Fridge fridge;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        deviceList = DeviceList.getInstance();
        fridge = (Fridge)deviceList.getSelectedDevice();

        Bindings.bindBidirectional(temperature.valueProperty(), fridge.temperatureProperty());
    }
}
