package com.example.assignment1;

public class ApplePhone {
    private int Id;
    private String Company_Name;
    private String Model;
    private int sales;
    private int SaleYear;
    private double Price;
    private String Country;


    public ApplePhone(int Id, String Company_Name, String Model, int sales, int SaleYear, double Price, String Country) {
        this.Id = Id;
        this.Company_Name = Company_Name;
        this.Model = Model;
        this.sales = sales;
        this.SaleYear = SaleYear;
        this.Price = Price;
        this.Country = Country;
    }



    public int getId() {
        return Id;
    }

    public String getCompany_Name() {
        return Company_Name;
    }

    public String getModel() {
        return Model;
    }

    public int getsales() {
        return sales;
    }

    public int getSaleYear() {
        return SaleYear;
    }
    public double getPrice() {
        return Price;
    }

    public String getCountry() {
        return Country;
    }

    public void setId(int Id) {
        if (Id>0)
            this.Id = Id;
        throw new IllegalArgumentException("Id must be greater than 0");

    }

    public void setCompany_Name(String Company_Name) {
        this.Company_Name = Company_Name;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setsales(int sales) {
        this.sales = sales;
    }
    public void setSaleYear(int SaleYear) {
        this.SaleYear = SaleYear;
    }
    public void setPrice(double Price) {
        this.Price = Price;
    }
    public void setCountry(String Country) {
        this.Country = Country;
    }
    public String toString()
    {
        return ("ApplePhone Info" + " " + "\n" +
                "Id=" + getId() + "\n" + ""+ "Company_Name=" + getCompany_Name() + "\n" +
                "Model=" + getModel() + "\n" +"sales=" + getsales() + "\n" + ""+ "SaleYear=" + getSaleYear() + "\n" +
                "Price=" + getPrice() + "\n" + ""+ "Country=" + getCountry());
    }

}

