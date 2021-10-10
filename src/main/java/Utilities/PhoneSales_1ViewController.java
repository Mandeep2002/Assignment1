package Utilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

import java.net.URL;
import java.util.ResourceBundle;

public class PhoneSales_1ViewController implements Initializable {

    @FXML
    private BarChart<?, ?> BarChart;

    @FXML
    private CategoryAxis X;

    @FXML
    private NumberAxis Y;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //normally this information would come from a DB and we would loop over
        //it to create these data points
//        XYChart.Series<String, Integer> sales = new XYChart.Series<>();
//        sales.getData().add(new XYChart.Data<>("Camera 1", 67));
//        sales.getData().add(new XYChart.Data<>("Camera 2", 102));
//        sales.getData().add(new XYChart.Data<>("Camera 3", 38));
//        sales.getData().add(new XYChart.Data<>("Camera 4", 97));
//        sales.getData().add(new XYChart.Data<>("Camera 5", 55));
//        sales.getData().add(new XYChart.Data<>("Camera 6", 250));

       // BarChart.getData().addAll(DBUtility.getSalesDataByCamera());
        BarChart.setLegendVisible(false);

        X.setLabel("Camera Brands");
        Y.setLabel("Number of units sold");
    }
}
