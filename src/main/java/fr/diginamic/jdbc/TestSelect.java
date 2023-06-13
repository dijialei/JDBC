package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect {
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
            ResultSet select = stm.executeQuery("select * from fournisseur");
            List<Fournisseur> fous =  new ArrayList<>();
            while (select.next()){
                Fournisseur fou = new Fournisseur(select.getInt(1), select.getString(2) );
                fous.add(fou);
            }
            for (Fournisseur fo:fous
                 ) {
                System.out.println("ID : " + fo.getId() + "      Nom : " + fo.getNom());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
