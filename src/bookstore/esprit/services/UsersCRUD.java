/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.services;

import bookstore.esprit.entities.Reclamations;
import bookstore.esprit.entities.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import test.MyConnexion;

/**
 *
 * @author Legion
 */
public class UsersCRUD {
    Connection cnx; 

    public UsersCRUD() {
        cnx=MyConnexion.getInstance().getCnx();
    }
    
    
    public void ajouterReclamation(Users u,Reclamations r){
        try{
            String requete="INSERT INTO reclamations (titre,texte,date_creation,user_reclamation_id) "
                + "VALUES(?,?,?,?)";
            String requeteForId ="SELECT max(reclamation_id) FROM reclamations ORDER BY reclamation_id DESC";
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setString(1,r.getTitre() );
        pst.setString(2,r.getTexte() );
        pst.setDate(3, (Date)r.getDate_creation());
        pst.setInt(4,u.getId_user());
        pst.executeUpdate();
        Statement st = cnx.prepareStatement(requeteForId);
            ResultSet sr = st.executeQuery(requeteForId);
            sr.next();
            r.setId(sr.getInt(1));
            
   
            System.out.println("Reclamation du user "+ u.getNom()+" ajouté !");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void ajouterUser(Users u){
        try{
            String requete="INSERT INTO Users (nom,prenom,email,password,date_dinscription,auteur_préféré,"
                    + "genre_préféré,statut) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);
        pst.setString(1,u.getNom());
        pst.setString(2,u.getPrenom());
        pst.setString(3,u.getEmail());
        pst.setString(4,u.getPassword());
        pst.setDate(5, (Date)u.getDate_dinscription());
        pst.setString(6,u.getAuteur_préféré());
        pst.setString(7,u.getGenre_préféré());
        pst.setString(8,u.getStatut());
        pst.executeUpdate();
            String requeteForId ="SELECT max(id_user) FROM users ORDER BY id_user DESC";
          Statement st = cnx.prepareStatement(requeteForId);
          ResultSet sr = st.executeQuery(requeteForId);
          sr.next();
          u.setId_user(sr.getInt(1));
        
        
            System.out.println("user "+ u.getNom()+"ajouté");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
