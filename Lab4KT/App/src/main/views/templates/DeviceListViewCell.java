package main.views.templates;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import main.models.Device;

import java.io.IOException;

public class DeviceListViewCell extends ListCell<Device>
{
    @FXML private Label deviceType;
    @FXML private Label deviceName;
    @FXML private Label deviceStatus;
    @FXML private GridPane pane;

    @Override
    protected void updateItem(Device item, boolean empty)
    {
        super.updateItem(item,empty);

        if(empty || item == null)
        {
            setText(null);
            setGraphic(null);
        }
        else
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeviceListViewCell.fxml"));
            loader.setController(this);
            try
            {
                loader.load();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            deviceType.setText("Устройство: " + String.valueOf(item.getClass().getSimpleName()));
            deviceName.setText("Название: " + String.valueOf(item.getName()));
            deviceStatus.setText((item.isEnabled() ? "Включено" : "Выключено"));

            setText(null);
            setGraphic(pane);
        }
    }
}
