package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {


    public static void main(String[] args) {
    Fournisseur fou = new Fournisseur(4,"L’Espace Création new");
    boolean result =  new FournisseurDaoJdbc().delete(fou);
        System.out.println(result?"done!":"fail!");
    }
}
