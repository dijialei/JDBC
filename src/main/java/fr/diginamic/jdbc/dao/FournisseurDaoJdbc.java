package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements IFournisseurDao{

    private static final String USERNAME;
    private static final String PASSWORD;
    private static final String URL;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        USERNAME = bundle.getString("username");
        PASSWORD = bundle.getString("password");
        URL = bundle.getString("url");
    }
    @Override
    public List<Fournisseur> extraire() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = connection.createStatement();
            ResultSet select = stm.executeQuery("select * from fournisseur");
            List<Fournisseur> fous =  new ArrayList<>();
            while (select.next()){
                Fournisseur fou = new Fournisseur(select.getInt(1), select.getString(2) );
                fous.add(fou);
            }
           return fous;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void insert(Fournisseur fournisseur) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = connection.createStatement();
            String sql = String.format("insert into fournisseur values (%d,'%s')",fournisseur.getId(),fournisseur.getNom());
            System.out.println(sql);
            int n = stm.executeUpdate(sql);
            System.out.println("done!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = connection.createStatement();
            String sql = String.format("update fournisseur set nom='%s' where nom='%s'",nouveauNom,ancienNom);
            int n = stm.executeUpdate(sql);

            return n;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;

    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = connection.createStatement();
            String sql =String.format("delete from fournisseur where nom='%s'",fournisseur.getNom());
            int n = stm.executeUpdate(sql);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
