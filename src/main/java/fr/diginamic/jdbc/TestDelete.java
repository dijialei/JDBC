package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final String URL;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        USERNAME = bundle.getString("username");
        PASSWORD = bundle.getString("password");
        URL = bundle.getString("url");
    }

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = connection.createStatement();
            int n = stm.executeUpdate("delete from fournisseur where nom='La Maison des Peintures'");
            System.out.println(n);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
