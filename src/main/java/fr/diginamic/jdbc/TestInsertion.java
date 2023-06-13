package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {


    public static void main(String[] args) {
        Fournisseur fou =new Fournisseur(4,"L’Espace Création");
        FournisseurDaoJdbc fouDao = new FournisseurDaoJdbc();
        fouDao.insert(fou);
    }
}
