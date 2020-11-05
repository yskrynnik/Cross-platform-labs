package main.controllers;

import com.jfoenix.controls.JFXSlider;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import main.models.AirConditioner;
import main.models.DeviceList;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class AirConditionerConfigController implements Initializable {
    @FXML private JFXSlider temperature;
    @FXML private JFXSlider fanSpeed;
    @FXML private JFXSlider swingAngle;
    @FXML private CheckBox sleepModeSwitchedOn;
    @FXML private ToggleGroup modes;

    private DeviceList deviceList;
    private AirConditioner airConditioner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        deviceList = DeviceList.getInstance();
        airConditioner = (AirConditioner) deviceList.getSelectedDevice();

       Bindings.bindBidirectional(temperature.valueProperty(), airConditioner.temperatureProperty());
       Bindings.bindBidirectional(fanSpeed.valueProperty(), airConditioner.fanSpeedProperty());
       Bindings.bindBidirectional(swingAngle.valueProperty(), airConditioner.swingAngleProperty());
       Bindings.bindBidirectional(sleepModeSwitchedOn.selectedProperty(),airConditioner.sleepModeEnabledProperty());

        // create map mapping from text to corresponding toggle
        Map<String, Toggle> map = new HashMap<>();
        for (Toggle t: modes.getToggles()) {
            map.put(((RadioButton) t).getText(), t);
        }

        InvalidationListener listener = new InvalidationListener() {

            // flag preventing circular updating
            boolean updating = false;

            @Override
            public void invalidated(Observable observable) {
                if (!updating) {
                    updating = true;

                    if (observable == modes.selectedToggleProperty()) {
                        // change as result of user interaction with RadioButton

                        // update property
                        RadioButton selectedToggle = (RadioButton) modes.getSelectedToggle();
                        airConditioner.modeProperty().set(selectedToggle == null ? "" : selectedToggle.getText());
                    } else {
                        // change as result of updating the property

                        // select corresponding toggle
                        Toggle toggleToSelect = map.get(airConditioner.modeProperty().get());
                        modes.selectToggle(toggleToSelect);
                    }

                    updating = false;
                }
            }

        };

        airConditioner.modeProperty().addListener(listener);
        modes.selectedToggleProperty().addListener(listener);
    }



}
