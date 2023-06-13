package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements IFournisseurDao {

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
        String sql = "select * from fournisseur";
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pstm = connection.prepareStatement(sql);) {

            ResultSet select = pstm.executeQuery();
            List<Fournisseur> fous = new ArrayList<>();
            while (select.next()) {
                Fournisseur fou = new Fournisseur(select.getInt(1), select.getString(2));
                fous.add(fou);
            }
            return fous;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void insert(Fournisseur fournisseur) {
        String sql = "insert into fournisseur values (?,?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

             PreparedStatement pstm = connection.prepareStatement(sql);){

            pstm.setInt(1, fournisseur.getId());
            pstm.setString(2, fournisseur.getNom());
            int n = pstm.executeUpdate();
            System.out.println("done!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        String sql = "update fournisseur set nom=? where nom=?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

             PreparedStatement pstm = connection.prepareStatement(sql);){

            pstm.setString(1, nouveauNom);
            pstm.setString(2, ancienNom);
            int n = pstm.executeUpdate();

            return n;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;

    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        String sql = "delete from fournisseur where nom=?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

             PreparedStatement pstm = connection.prepareStatement(sql);) {

            pstm.setString(1, fournisseur.getNom());
            int n = pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
