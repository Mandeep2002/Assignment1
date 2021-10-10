package Utilities;

import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtility {
    private static String user = "student";
    private static String pw = "student";
    private static String connectUrl = "jdbc:mysql://localhost:DESKTOP-JGTKCGH\\MYSQL/ApplestockDatabase";
    public static XYChart.Series<String, Integer> getSalesDataByCamera()
    {
        XYChart.Series<String, Integer> salesData = new XYChart.Series<>();

        String sql = "SELECT CONCAT(Company_Name,'-',Model) AS 'ApplePhone', sales AS 'Items Sold' " +
                "FROM APPLEPHONE_2 INNER JOIN PhoneSales_1 ON APPLEPHONE_2.ID = PhoneSales_1.ID;";



        try(
                Connection conn = DriverManager.getConnection(connectUrl, user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while (resultSet.next())
            {
                salesData.getData().add(new XYChart.Data<>(resultSet.getString("ApplePhone"), resultSet.getInt("Items Sold")));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return salesData;
    }



}
