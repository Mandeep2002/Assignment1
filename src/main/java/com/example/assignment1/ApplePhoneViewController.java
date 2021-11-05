package com.example.assignment1;


import Utilities.DBUtility;
import Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ApplePhoneViewController implements Initializable {

    @FXML
    private BarChart<String, Integer> BarChart;

    @FXML
    private CategoryAxis X;

    @FXML
    private NumberAxis Y;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       BarChart.getData().addAll(DBUtility.getSalesDataByApplePhone());
        BarChart.setLegendVisible(false);

        X.setLabel("ApplePhone");
        Y.setLabel("Number of phone sold");
    }

    @FXML
    private void viewtable(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "table-view.fxml", "Applephone sales table");
    }


}