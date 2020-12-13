/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.services;

import bookstore.esprit.entities.Livre;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.MyConnexion;

/**
 *
 * @author Alia
 */
public class LivreCRUD {


    public void AjouterLivre(Livre l) {
        try {
            /*String requete = "INSERT INTO livre(identifiant,titre,auteur, catégorie,description,typelivre,prix,nombre_page)"
                    +"VALUES ('"+l.getIdentifiant()+"','"+l.getTitre()+"', '"+l.getAuteur()+"','"+l.getCatégorie()+"','"+l.getDescription()+"','"+l.getTypelivre()+"','"+l.getPrix()+"','"+l.getNombre_page()+"') ";*/
            String requete = "INSERT INTO livre(identifiant,titre,auteur, catégorie,description,typelivre,prix,nombre_page)"
                    +"VALUES (?,?,?,?,?,?,?,?) ";
            
            
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);
            pst.setString(1,l.getIdentifiant());
            pst.setString(2, l.getTitre());
            pst.setString(3, l.getAuteur());
            pst.setString(4, l.getCatégorie());
            pst.setString(5, l.getDescription());
            pst.setString(6, l.getTypelivre());
            pst.setFloat(7,l.getPrix());
            pst.setInt(8, l.getNombre_page());
            pst.executeUpdate();
            System.out.println("livre ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
