package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {
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
            int n = stm.executeUpdate("insert into fournisseur values (4,'La Maison de la Peinture')");
            System.out.println(n);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
