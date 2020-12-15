/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.services;

import bookstore.esprit.entities.users;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import test.MyConnexion;

/**
 *
 * @author Dhia
 */
public class usersCrud {
    public Boolean inscrire(users u){
        Boolean test = false;
        try {
//            String requete ="INSERT INTO personne(nom,prenom)"
//                    + " VALUES ('"+p.getNom()+"','"+p.getPrenom()+"')";
 String requete ="INSERT INTO users(nom,prenom,email,password,date_dinscription,auteur_préféré,genre_préféré,statut)"
         + " VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getPassword());
             pst.setDate(5, (Date) u.getDate_dinscription());
            pst.setString(6, u.getAuteur_préféré());
            pst.setString(7, u.getGenre_préféré());
            pst.setString(8, u.getStatut());
           // pst.setInt(9, u.getId_user());
            pst.executeUpdate();
            System.out.println("utilisateur ajouté !");
            test = true;
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
    return test;}
    
}
