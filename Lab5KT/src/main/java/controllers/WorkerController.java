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
import models.Worker;
import models.MongoDBObj;
import org.bson.Document;

import java.net.URL;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

public class WorkerController implements Initializable {
    @FXML
    private TableView<Worker> table;
    @FXML
    private TableColumn<Worker, String> columnName;
    @FXML
    private TableColumn<Worker, String> columnPhone;
    @FXML
    private TableColumn<Worker, String> columnSalary;

    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField salary;

    private MongoDatabase db;
    private ObservableList<Worker> workers = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = MongoDBObj.getDB();

        columnName.setCellValueFactory(new PropertyValueFactory<Worker, String>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Worker, String>("phone"));
        columnSalary.setCellValueFactory(new PropertyValueFactory<Worker, String>("salary"));

        table.setItems(workers);

        getWorkers();
    }

    public void addWorker(ActionEvent actionEvent) {
        var collection = db.getCollection("Workers");

        Document document = new Document();
        document.put("name", name.getText());
        document.put("phone", phone.getText());
        document.put("salary", salary.getText());

        collection.insertOne(document);

        getWorkers();
    }

    public void refresh(ActionEvent actionEvent) {
        getWorkers();
    }

    public void deleteWorker(ActionEvent actionEvent) {
        if (table.getSelectionModel().selectedItemProperty().getValue() == null) return;

        var collection = db.getCollection("Workers");
        collection.deleteOne(eq("_id", table.getSelectionModel().selectedItemProperty().getValue().getId()));

        getWorkers();
    }

    public void getWorkers() {
        workers.clear();

        var collection = db.getCollection("Workers");
        for (Document doc : collection.find()) {
            workers.add(new Worker(doc));
        }
    }
}