package main.controllers;

import main.models.*;
import main.views.templates.DeviceListViewCell;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private ListView<Device> listView;
    @FXML
    private ToggleGroup devices;

    private DeviceList deviceList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deviceList = DeviceList.getInstance();
        listView.itemsProperty().bind(deviceList.itemsProperty());
        listView.setCellFactory(deviceListView -> new DeviceListViewCell());
    }

    public void createDevice(ActionEvent actionEvent)
    {
        RadioButton selectedRB =  (RadioButton)devices.getSelectedToggle();
        String selectedDevice = selectedRB.getText();

        Device device = null;
        switch (selectedDevice)
        {
            case "Кондиционер": device = new AirConditioner("Кондиционер"); break;
            case "Холодильник": device = new Fridge("Холодильник"); break;
            case "Настольная лампа": device = new Lamp("Настольная лампа"); break;
            case "Датчик движения": device = new MotionSensor("Датчик движения"); break;
            case "Термометр": device = new Thermometer("Термометр"); break;
        }
        if(device != null)
            deviceList.getItems().add(device);
    }

    public void configDevice(ActionEvent actionEvent) throws IOException
    {
        if(listView.getSelectionModel().getSelectedItem() == null)
            return;

        deviceList.setSelectedDevice(listView.getSelectionModel().getSelectedItem());

        pane.getChildren().clear();
        pane.getChildren().add(FXMLLoader.load(getClass().getResource("/main/views/configDeviceView.fxml")));
    }
    public void deleteDevice(ActionEvent actionEvent)
    {
        if(listView.getSelectionModel().getSelectedItem() == null)
            return;

        deviceList.getItems().remove(listView.getSelectionModel().getSelectedItem());
    }
}