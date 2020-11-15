package controllers;

import com.mongodb.client.MongoDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Material;
import models.MongoDBObj;
import org.bson.Document;

import java.net.URL;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;
import static java.lang.Integer.parseInt;

public class MaterialController implements Initializable {
    @FXML
    private TableView<Material> table;
    @FXML
    private TableColumn<Material, String> columnName;
    @FXML
    private TableColumn<Material, Integer> columnAmount;

    @FXML
    private TextField name;
    @FXML
    private TextField amount;

    private MongoDatabase db;
    private ObservableList<Material> materials = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = MongoDBObj.getDB();

        columnName.setCellValueFactory(new PropertyValueFactory<Material, String>("name"));
        columnAmount.setCellValueFactory(new PropertyValueFactory<Material, Integer>("amount"));

        table.setItems(materials);

        getMaterials();
    }

    public void addMaterial(ActionEvent actionEvent) {
        var collection = db.getCollection("Materials");

        Document document = new Document();
        document.put("name", name.getText());
        document.put("amount", parseInt(amount.getText()));

        collection.insertOne(document);

        getMaterials();
    }

    public void refresh(ActionEvent actionEvent) {
        getMaterials();
    }

    public void deleteMaterial(ActionEvent actionEvent) {
        if (table.getSelectionModel().selectedItemProperty().getValue() == null) return;

        var collection = db.getCollection("Materials");
        collection.deleteOne(eq("_id", table.getSelectionModel().selectedItemProperty().getValue().getId()));

        getMaterials();
    }

    public void getMaterials() {
        materials.clear();

        var collection = db.getCollection("Materials");
        for (Document doc : collection.find()) {
            materials.add(new Material(doc));
        }
    }
}