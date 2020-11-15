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
import models.Country;
import models.MongoDBObj;
import org.bson.Document;

import java.net.URL;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

public class CountryController implements Initializable {
    @FXML
    private TableView<Country> table;
    @FXML
    private TableColumn<Country, String> columnName;
    @FXML
    private TableColumn<Country, String> columnShortName;

    @FXML
    private TextField name;
    @FXML
    private TextField shortName;

    private MongoDatabase db;
    private ObservableList<Country> countries = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = MongoDBObj.getDB();

        columnName.setCellValueFactory(new PropertyValueFactory<Country, String>("name"));
        columnShortName.setCellValueFactory(new PropertyValueFactory<Country, String>("shortName"));

        table.setItems(countries);

        getCountries();
    }

    public void addCountry(ActionEvent actionEvent) {
        var collection = db.getCollection("Countries");

        Document document = new Document();
        document.put("name", name.getText());
        document.put("shortName", shortName.getText());

        collection.insertOne(document);

        getCountries();
    }

    public void refresh(ActionEvent actionEvent) {
        getCountries();
    }

    public void deleteCountry(ActionEvent actionEvent) {
        if (table.getSelectionModel().selectedItemProperty().getValue() == null) return;

        var collection = db.getCollection("Countries");
        collection.deleteOne(eq("_id", table.getSelectionModel().selectedItemProperty().getValue().getId()));

        getCountries();
    }

    public void getCountries() {
        countries.clear();

        var collection = db.getCollection("Countries");
        for (Document doc : collection.find()) {
            countries.add(new Country(doc));
        }
    }
}
