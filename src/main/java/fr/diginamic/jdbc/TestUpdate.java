package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {


    public static void main(String[] args) {
        FournisseurDaoJdbc fouDao = new FournisseurDaoJdbc();
        int n = fouDao.update("L’Espace Création","L’Espace Création new");
        System.out.println(n==1 ? "done!":"fail!");

    }
}
