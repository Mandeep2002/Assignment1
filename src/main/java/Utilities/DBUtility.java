package Utilities;

import com.example.assignment1.ApplePhone;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "student";
    private static String pw = "student";
    private static String connectUrl = "jdbc:mysql://localhost:3306/ApplestockDatabase";
    public static XYChart.Series<String, Integer> getSalesDataByApplePhone()
    {
        XYChart.Series<String, Integer> salesData = new XYChart.Series<>();

        String sql = "SELECT CONCAT(Company_Name,'-',Model) AS 'ApplePhone', sales AS 'Items Sold'"+
        "FROM APPLEPHONE_2 INNER JOIN PhoneSales_1 ON APPLEPHONE_2.ID = PhoneSales_1.ID;";

        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ApplestockDatabase", "student","student");
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


    public static ArrayList<ApplePhone> getApplePhoneDetails()
    {
        ArrayList<ApplePhone> applePhones = new ArrayList<>();

        String sql = "select APPLEPHONE_2.ID, Company_Name, Model, sales, SaleYear, Price, Country\n" +
                "from APPLEPHONE_2 INNER JOIN PhoneSales_1 ON APPLEPHONE_2.ID = PhoneSales_1.ID ;";

        try(
                Connection conn = DriverManager.getConnection(connectUrl, user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while (resultSet.next())
            {
                int ID = resultSet.getInt("ID");
                String Company_Name = resultSet.getString("Company_Name");
                String Model = resultSet.getString("Model");
                int sales = resultSet.getInt("sales");
                int SaleYear = resultSet.getInt("SaleYear");
                double Price = resultSet.getDouble("Price");
                String Country = resultSet.getString("Country");

                ApplePhone applePhone = new ApplePhone(ID,Company_Name,Model,sales,SaleYear,Price, Country);

                applePhones.add(applePhone);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return applePhones;
    }
}



