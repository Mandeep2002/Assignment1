package com.example.assignment1;


import Utilities.DBUtility;
import Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {
    @FXML
    private TableView<ApplePhone> tableview;
    @FXML
    private TableColumn<ApplePhone, Integer> idcolumn;

    @FXML
    private TableColumn<ApplePhone, String> company_namecolumn;

    @FXML
    private TableColumn<ApplePhone, String> modelcolumn;

    @FXML
    private TableColumn<ApplePhone, Integer> salescolumn;

    @FXML
    private TableColumn<ApplePhone, Integer> saleyearcolumn;

    @FXML
    private TableColumn<ApplePhone, Double> pricecolumn;

    @FXML
    private TableColumn<ApplePhone, String> countrycolumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        company_namecolumn.setCellValueFactory(new PropertyValueFactory<>("Company_Name"));
        modelcolumn.setCellValueFactory(new PropertyValueFactory<>("Model"));

        saleyearcolumn.setCellValueFactory(new PropertyValueFactory<>("SaleYear"));
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        countrycolumn.setCellValueFactory(new PropertyValueFactory<>("Country"));


        tableview.getItems().addAll(DBUtility.getApplePhoneDetails());
    }
    @FXML
    private void applePhone(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "create-phone-view.fxml","Apple phone Sales ");
    }

}
