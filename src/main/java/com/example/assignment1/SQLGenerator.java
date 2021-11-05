package com.example.assignment1;



import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;

public class SQLGenerator {

    public static void createSQL()
    {
        //create a random number generator
        SecureRandom rng = new SecureRandom();

        //open the formatter in the try with resources (....) block so that it will auto close
        try(
                Formatter formatter = new Formatter("PhoneSales_1.sql");
        )
        {
            //loop 5000 times to create random records
            for (int i=1; i<=5000; i++)
            {
                LocalDate dateSold = LocalDate.now().minusDays(rng.nextInt(1095));
                formatter.format("INSERT INTO PhoneSales_1 (ID, dateSold) VALUES (%d, '%s');%n",rng.nextInt(11)+1,dateSold);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readFile()
    {
        try {
            Scanner scanner = new Scanner(new File("PhoneSales_1.sql"));

            while (scanner.hasNext())
            {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile();
    }
}