package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect {

    public static void main(String[] args) {
        List<Fournisseur> fous = new FournisseurDaoJdbc().extraire();
        for (Fournisseur fo:fous
        ) {
            System.out.println("ID : " + fo.getId() + "      Nom : " + fo.getNom());
        }
    }
}
