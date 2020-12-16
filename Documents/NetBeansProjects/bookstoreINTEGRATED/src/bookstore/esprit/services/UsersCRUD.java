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
import java.util.ArrayList;
import java.util.List;
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
        pst.setInt(4,46);
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
    
 public void ajouterUser(Users u) {
        try {
            //  String requete = "INSERT INTO users(nom,prenom,email,password,date_dinscription,auteur_préféré,genre_préféré,statut) VALUES"
            //      + " (" + u.getNom() + "," + u.getPrenom() + "," + u.getEmail() + "," + u.getPassword() + "," + u.getDate_inscription() + "," + u.getAuteur_prefere() + "," + u.getGenre_prefere() + "," + u.getStatut() + ")";
            String requete = "INSERT INTO users(nom,prenom,email,password,auteur_préféré,genre_préféré,statut) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnexion().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getPassword());

            pst.setString(5, u.getAuteur_préféré());
            pst.setString(6, u.getGenre_préféré());
            pst.setString(7, u.getStatut());
            pst.executeUpdate();
            System.out.println("Personne ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void banUser(Users u) {
        try {
            String requete = "UPDATE users SET statut='Banned' WHERE id_user=" + u.getId_user();
            Statement st = new MyConnexion().getCnx().prepareStatement(requete) ;
            st.executeUpdate(requete);
            System.out.println("use who got the id" + u.getId_user() + "IS BANNNED BROOO");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
      public void modifierUserNom(int id, String nom) {
        try {
            String requete = "UPDATE USERS SET nom=? WHERE id_user=?";
            // Statement st = new MyConnection().getCnx().createStatement();
            PreparedStatement pst = new MyConnexion().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, nom);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("Nom de user ayant comme id "+id+" Modifié!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierUserPrenom(int id, String prenom) {
        try {
            String requete = "UPDATE USERS SET prenom=? WHERE id_user=?";
            // Statement st = new MyConnection().getCnx().createStatement();
            PreparedStatement pst = new MyConnexion().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, prenom);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("Prenom de user ayant comme id "+id+" Modifié!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void modifierUserEmail(int id, String email) {
        try {
            String requete = "UPDATE USERS SET email=? WHERE id_user=?";
            // Statement st = new MyConnection().getCnx().createStatement();
            PreparedStatement pst = new MyConnexion().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, email);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("Email de user ayant comme id "+id+" Modifié!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void modifierUserStatut(int id, String statut) {
        try {
            String requete = "UPDATE USERS SET statut=? WHERE id_user=?";
            // Statement st = new MyConnection().getCnx().createStatement();
            PreparedStatement pst = new MyConnexion().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, statut);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("Statut de user ayant comme id "+id+" Modifié!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void modifierUserBanned(int id, int ban) {
        try {
            String requete = "UPDATE USERS SET banned=? WHERE id_user=?";
            // Statement st = new MyConnection().getCnx().createStatement();
            PreparedStatement pst = new MyConnexion().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, ban);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("létat du compte ayant comme id "+id+" modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
                 public List<Users> listerUtilisateurs() {
        List<Users> myList = new ArrayList<Users>();
        try {
            String requete = "SELECT * FROM users";
            Statement st =  new MyConnexion().getCnx() 
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Users u = new Users();

                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));

                u.setAuteur_préféré(rs.getString("auteur_préféré"));
                u.setGenre_préféré(rs.getString("genre_préféré"));
                u.setStatut(rs.getString("statut"));

                myList.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
   
}
